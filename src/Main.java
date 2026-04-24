import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        String filename = "/home/krisjscott/Documents/Program/java/Music player/Music/sonican-background-music-new-age-nature-465069.wav";
        File file = new File(filename);


        try(AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
            Scanner sc = new Scanner(System.in)){
            String response = " ";
            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);


            while(!response.equals("Q")){

                System.out.println("P=PLAY");
                System.out.println("Q=QUIT");
                System.out.println("R=RESET");
                System.out.println("S=STOP");
                System.out.print("Enter a choice: ");
                response = sc.next().toUpperCase();

                switch(response){
                    case "P" -> clip.start();
                    case "Q" -> clip.close();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "S" -> clip.stop();
                    default -> System.out.println("Invalid choice");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Could not locate file");
        }
        catch(IOException e){
            System.out.println("File Not Found");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio file not supported");
        }
        catch(LineUnavailableException e){
            System.out.println("It's unavailable");
        }
        finally{
            System.out.println("Bye");
        }
    }
}
