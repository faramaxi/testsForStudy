package Api;

public class UserTimeResponse extends UserTime {
    private String updatedAt;

    public UserTimeResponse() {
        super();
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
