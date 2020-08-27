public enum Cup {
    Small,Medium,Big;
    @Override
    public String toString() {
        switch (this){
            case Small:    return "Small";
            case Medium:   return "Medium";
            case Big:    return "Big";
            default:        return "Unspecified";
        }
    }

}
