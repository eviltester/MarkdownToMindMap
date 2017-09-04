package co.uk.compendiumdev.markdown.mm;

/**
 * Created by Alan on 04/09/2017.
 */
public class Slide {
    private String title;
    private StringBuilder lines = new StringBuilder();

    public boolean hasATitle() {
        return title!=null;
    }

    public void setTitle(String title) {

        String titleToBe = title.trim();

        int possStart =0;

        for(; possStart< titleToBe.length(); possStart++){
            if(titleToBe.charAt(possStart) == '#' || titleToBe.charAt(possStart) == ' '){
                // valid star char ignore
            }else{
                break;
            }
        }

        this.title = titleToBe.substring(possStart);
    }

    public void addTextLine(String line) {
        lines.append(line);
        lines.append(System.lineSeparator());
    }

    public String getTitle() {
        return title;
    }
}
