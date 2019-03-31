package engineTest;

public class tileID {
    public int id;
    public String filename;
    private String filepath;

    public tileID(){}

    public String getFilename(int id)
    {
        this.id = id;
        filepath = "./res/tilesTXT/";

        switch (this.id){
            case 0:
                filename = filepath + "air.png";
                break;
            case 1:
                filename = filepath + "testTile.png";
                break;
            case 2:
                filename = filepath + "man.png";
                break;
            case 3:
                filename = filepath + "grass.png";
        }
        return filename;
    }

}
