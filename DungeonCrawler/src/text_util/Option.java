package text_util;


public class Option {
    private String optionText;
    private int optionId;

    public String getOptionText() {
        return optionText;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public Option(String optionText, int optionId) {
        this.optionId = optionId;
        this.optionText = optionText;
    }

}
