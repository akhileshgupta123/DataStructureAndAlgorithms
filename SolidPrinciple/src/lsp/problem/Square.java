package lsp.problem;

public class Square extends Rectangle{
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Setting height equal to width
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Setting width equal to height
    }
}
