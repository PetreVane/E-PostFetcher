package com.orbSec.constants;

/**
 * @author Created by Petre Vane
 * @project EmailClient
 */

public enum FontSize {
    SMALL,
    MEDIUM,
    LARGE;

    public String toString() {
        String result;
        switch (this) {
            case LARGE:
                result = "large";
                break;
            case SMALL:
                result = "small";
                break;
            case MEDIUM:
                result = "medium";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
        return result;
    }

    public String getFilePathFor(FontSize fontSize) {

        switch (fontSize) {
            case LARGE:
                return "css/fontBig.css";
            case SMALL:
                return "css/fontSmall.css";
            case MEDIUM:
                return "css/default.css";
            default:
                return null;
        }
    }
}
