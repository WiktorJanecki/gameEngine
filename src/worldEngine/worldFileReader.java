package worldEngine;

import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.Scanner;

public class worldFileReader {
    Scanner scanner;
    String path;
    String worldname;
    String sizeX = "";
    String sizeY = "";
    int [] [] tileid;
    char[] line;

    public worldFileReader(String worldname)
    {
        this.worldname = worldname;
        path = "./res/worlds/";

        try
        {
            scanner = new Scanner(new File(path+worldname+".txt"));
        }
        catch (IOException e)
        {
            System.out.println("Can't load world file!");
        }


        line = scanner.nextLine().toCharArray();
        int x = 0;

        //Get map x size
        for(int i = 0;i < line.length;i++)
        {
            if(line[i] == 59){break;} // 59 = ;
            sizeX = sizeX + line[i];
            x = i +2;
        }
        System.out.print("World size : "+(Integer.parseInt(sizeX)-1)+",");

        //Get map y size
        for(int i = x;i < line.length;i++)
        {
            if(line[i] == 59){break;} // 59 = ;
            sizeY = sizeY + line[i];
            x = i +2;
        }

        System.out.println(Integer.parseInt(sizeY)-1);
        tileid = new int [Integer.parseInt(sizeX)][Integer.parseInt(sizeY)];

        //line = scanner.nextLine().toCharArray();

        for(int i = 0; i < tileid[0].length;i++)
        {
            line = scanner.nextLine().toCharArray();
            int y = 0;
            for(int j= 0;j <tileid.length;j++)
            {

                String letter = "";
                for(int k = y;k < line.length;k++)
                {
                    if(line[k] == 59){break;} // 59 = ;
                    letter = letter + line[k];
                    y = k +2;
                }
                tileid[j][i] = Integer.parseInt(letter);
            }
        }


        for(int i = 0; i < tileid[0].length;i++)
        {
            for(int j= 0;j <tileid.length;j++)
            {
               // System.out.println(tileid[j][i]);
            }
        }
        scanner.close();
    }

    public int[][] getTileid() {
        return tileid;
    }
}
