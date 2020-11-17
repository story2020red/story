package red.story.story.entity;

/**
 * @author storyRed
 * 2020-11-17 03:39:10 下午
 */

public enum UserBehavior {
    OFF_LINE("off-line"),
    ON_LINE("on-line"),
    SIGN_IN("sign-in"),
    NOT_LOGGED_IN("not-logged-in");

    private String value;
    UserBehavior(String a) {
        value=a;
    }

    public String getValue() {
        return value;
    }
}
