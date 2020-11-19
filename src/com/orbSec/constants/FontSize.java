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
}
