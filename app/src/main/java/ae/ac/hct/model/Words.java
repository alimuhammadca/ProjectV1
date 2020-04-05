package ae.ac.hct.model;

public class Words {

    private String example;
    private String meaning;
    private String partOfSpeech;
    private String word;

    public Words() {
    }

    public Words(String example, String meaning, String partOfSpeech, String word) {
        this.example = example;
        this.meaning = meaning;
        this.partOfSpeech = partOfSpeech;
        this.word = word;
    }

    public String getExample() {
        return example;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getWord() {
        return word;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Words{" +
                "example='" + example + '\'' +
                ", meaning='" + meaning + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
