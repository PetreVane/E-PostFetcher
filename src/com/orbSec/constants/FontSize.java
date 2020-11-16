package com.orbSec.constants;

public enum FontSize {
    SMALL,
    MEDIUM,
    LARGE;

    public String toString() {
        switch (this) {
            case LARGE:return "large";
            case SMALL:return "small";
            case MEDIUM: return "medium";
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
