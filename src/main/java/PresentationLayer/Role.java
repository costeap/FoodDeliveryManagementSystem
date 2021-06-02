package PresentationLayer;

public enum Role {
    ADMIN("ADMIN"),
    CLIENT("CLIENT"),
    EMPLOYEE("EMPLOYEE");

    private final String roleType;

    Role(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }

    public static Role setRole(String roleType) {
        switch (roleType) {
            case "ADMIN":
                return Role.ADMIN;
            case "EMPLOYEE":
                return Role.EMPLOYEE;
            case "CLIENT":
                return Role.CLIENT;
            default:
                return null;
        }
    }

}
