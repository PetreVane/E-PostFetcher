package com.orbSec.constants;

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
        String result= "";

        switch (fontSize) {
            case LARGE:
                result = "css/fontBig.css";
            case SMALL:
                result = "css/fontSmall.css";
            case MEDIUM:
                result = "css/default.css";
        }

        return result;
    }
}
