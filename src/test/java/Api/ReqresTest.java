package Api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private final static String URL="https://reqres.in/";
    @Test
    public void checkAvatarAndIdTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecOK200());
        List<UserData>users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

        List<String> avatars =users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids =users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        for(int i =0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
    @Test
    public void successRegTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecOK200());
        Integer id =4;
        String token="QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in","pistol");
        SuccessReg successReg=given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());
        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }
    @Test
    public void unSuccessRegTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecError400());
        Register user = new Register("sydney@fife","");
        UnSuccessReg unSuccessReg=given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Missing password",unSuccessReg.getError());
    }
    @Test
    public void sortedYearsTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecOK200());
        List<ColorsData>colors= given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data",ColorsData.class);
        List<Integer> years= colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears=years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears,years);
        System.out.println(years);
        System.out.println(sortedYears);
    }
    @Test
    public void deleteUserTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }
    @Test
    public void timeTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecOK200());
        UserTime user=new UserTime("morpheus","zion resident");
        UserTimeResponse response= given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);

        String regex="(.{5})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex,"");
        System.out.println(currentTime);
        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex,""));
        System.out.println(response.getUpdatedAt().replaceAll(regex,""));
   //     int i=1;
    }
}