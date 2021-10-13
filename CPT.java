// The "Hangman Game"
//David and Ryan
import java.awt.*;
import hsa.Console;
import java.io.*;
import java.awt.image.*;

public class CPT implements ImageObserver
{
  
  static Console a,c;
  private Image Pic;
  public static void main (String[] args) throws IOException
  {
    a = new Console (40,120);
    c = new Console ();
    //Declaring variables to be used
    String  word,category,line, hiddenline, guesscheck,playagain, wordc,name;
    int count, number,howmany, strike,correct,linecount,hiddencount, guessindex, howmanyguess, countguess,x,y,z, lettercount,hi,low,scorecount;
    char guessletter, stringindex;
    BufferedReader input;                                                                                                    
    hi = -100;
    low = 100;
    while (true)
    {
      scorecount = 0;//Set score count to 0 so it doesn't continue
      //Setting background and text colour
      a.setTextBackgroundColor(Color.white);
      a.setColor(Color.BLACK);
      a.setTextColor(Color.black);
      a.clear ();//Refresh to update background colour
      count = 0;
      x=500;
      y=500;
      z=240;
      a.setFont (new Font ("Sansserif",Font.BOLD,40));
      a.drawString ("Hangman Game",320,160);//start screen
      a.setFont (new Font ("Sansserif",Font.BOLD,10));
      a.drawString ("By David Hanna and Ryan Liyanage",390,180);
      c.println ("Enter name to continue");
      name = c.readLine ();//name will be display for high scores
      //Clear
      a.clear ();
      c.clear ();
      while (true)
      { 
        c.println  ("What category would you like to choose?");                                                  
        c.println ("1 - Countries"); 
        c.println ("2 - Phone Brands");          
        c.println ("3 - Animals"); 
        category = c.readLine (); //user picks numbers 1-3
        a.setFont (new Font ("Sansserif",Font.PLAIN,15));
        
        c.clear ();
        //Input will be be reading in the respective file determined by the user's choice
        if (category.equals  ("1"))
        {
          a.drawString ("Category: Countries",200,500);
          input = new BufferedReader (new FileReader ("countries.txt"));
          break;
        }
        else if (category.equals("2"))
        {
          a.drawString ("Category: Phone brands",200,500);
          input = new BufferedReader (new FileReader ("phonebrands.txt"));
          break;
        }
        else if (category.equals("3"))
        {
          a.drawString ("Category: Animals",200,500);
          input = new BufferedReader (new FileReader ("animals.txt"));
          break;
        }
        else
        {
          c.println ("Thats not an option. Please try again."); //error trap
          
        }
      }
      //random word generator
      number = (int) (Math.random () * 10 + 1);
      do
      {
        wordc = input.readLine ();
        count++;
      }
      while (count != number);
      
      word = wordc.toLowerCase ();//sets the word to lowercase so both cases count
      strike = 0; //how many times the user gets a letter wrong
      correct = 0; //how many times they guessed right
      String guess;
      
      
      a.setFont (new Font ("Sansserif",Font.BOLD,40));
      a.drawString ("Hangman Game",570,140);
      a.setFont (new Font ("Sansserif",Font.BOLD,100));
      a.drawString ("|",620,260); // pole line
      a.drawString ("____",636,173); // bar line
      a.drawString ("|",820,260); //pole line 
      a.drawString ("|",620,350); //pole line
      a.drawString ("|",620,440); //pole line
      a.drawString ("_",615,445); //base line
      
      
      hiddencount = 0;
      count = 0;
      int index = 0;
      linecount = 0;
      a.setFont (new Font ("Sansserif",Font.BOLD,40));
      //the lines and spaces
      howmany=0;
      while (true) //external line print
      {
        a.setFont (new Font ("Sansserif",Font.BOLD,40));
        a.drawString ("-",z,450);//it draws "-" for every letter in the word
        howmany++;
        if (word.length () == howmany)
        {
          break;
        }
        else
          z=z+30;
      }
      
      //Sets and counts variables to be used later for checking to see if the user entered the same thing twice and checking if the guess is correct
      do 
      {
        line = ("_ ");
        hiddenline = (hiddencount + "");
        linecount++;
        hiddencount++; 
      }
      while (linecount != (word.length ()-1));
      line = line + "_";
      
      hiddenline ="";
      while (true)
      {
        hiddenline = hiddenline + count;
        if (count == hiddencount)
          break;
        else
          count++;
      }
      guesscheck = "";
      
      while (true)
      {
        //if the user got 7 strikes quit, otherwise if they got all words correct, quit, otherwise ask for the next guess
        if (strike >= 7) 
          break;
        else if (correct == word.length ())
          break;
        else
        {
          
          while (true)
          {
            //Resets the scan variables so it won't continue from the last scan
            countguess = 0;
            guessindex = 0;
            while (true)
            {
              c.print ("Enter a letter: ");
              guess = c.readLine ();
              guess.toLowerCase (); //sets guess to lower case so the user won't get striked for the wrong case
              //manually make sure the user enters a single letter from a-z
              if (guess.equalsIgnoreCase ("q")) 
                break;
              else if (guess.equalsIgnoreCase ("w")) 
                break;
              else if (guess.equalsIgnoreCase ("e")) 
                break;
              else if (guess.equalsIgnoreCase ("r")) 
                break;
              else if (guess.equalsIgnoreCase ("t")) 
                break;
              else if (guess.equalsIgnoreCase ("y")) 
                break;
              else if (guess.equalsIgnoreCase ("u")) 
                break;
              else if (guess.equalsIgnoreCase ("i")) 
                break;
              else if (guess.equalsIgnoreCase ("o")) 
                break;
              else if (guess.equalsIgnoreCase ("p")) 
                break;
              else if (guess.equalsIgnoreCase ("a"))
                break;
              else if (guess.equalsIgnoreCase ("s")) 
                break;
              else if (guess.equalsIgnoreCase ("d")) 
                break;
              else if (guess.equalsIgnoreCase ("f")) 
                break;
              else if (guess.equalsIgnoreCase ("g")) 
                break;
              else if (guess.equalsIgnoreCase ("h")) 
                break;
              else if (guess.equalsIgnoreCase ("j")) 
                break;
              else if (guess.equalsIgnoreCase ("k")) 
                break;
              else if (guess.equalsIgnoreCase ("l")) 
                break;
              else if (guess.equalsIgnoreCase ("z")) 
                break;
              else if (guess.equalsIgnoreCase ("x")) 
                break;
              else if (guess.equalsIgnoreCase ("c")) 
                break;
              else if (guess.equalsIgnoreCase ("v")) 
                break;
              else if (guess.equalsIgnoreCase ("b")) 
                break;
              else if (guess.equalsIgnoreCase ("n")) 
                break;
              else if (guess.equalsIgnoreCase ("m")) 
                break;
              
              else
                c.println ("Please enter a letter from A-Z"); //error trap
            }
            //Checks from a list of letters to make sure the user doesnt enter the same letter twice (error trap)
            for (;;) 
            {
              howmanyguess = guesscheck.indexOf (guess, guessindex);
              
              if (howmanyguess != -1)
              {
                countguess++;
                guessindex = howmanyguess + 1; 
              }
              else
              {
                break;
              }
            }
            
            //If the program finds a letter that was already entered
            if (countguess != 0)
            {     
              c.println ("You already entered that"); //error trap
            }
            else
            {
              //If the new letter passes it gets added to the list
              guesscheck = guesscheck + guess;
              break;
            }
            
          }
          //Resets this scanner so it gets all of the same letters in the word
          guessletter = guess.charAt (0);
          index = 0;
          while (true) 
          {
            //Scans for the guess in the random word
            howmany = word.indexOf (guessletter, index);
            if (howmany != -1) 
            {
              //If it is found then the user is correct the program acts accordingly
              count++;  
              index = howmany + 1; 
              stringindex = hiddenline.charAt (index-1);
              hiddenline.replace (stringindex, guessletter);
              correct++;
              scorecount++;
              lettercount = 0;
              //it prints a letter above the line in all it's corresponding spots
              do 
              {
                a.setFont (new Font ("Sansserif",Font.BOLD,15));
                if (index ==1)
                {
                  a.drawString (guess,249,435); 
                  lettercount++;
                  break;
                }
                else if (index ==2)
                {
                  a.drawString (guess,279,435); 
                  lettercount++;
                  break;
                }
                else if (index ==3)
                {
                  a.drawString (guess,309,435);
                  lettercount++;
                  break;
                }
                else if (index ==4)
                {
                  a.drawString (guess,339,435);
                  lettercount++;
                  break;
                }
                else if (index ==5)
                {
                  a.drawString (guess,369,435); 
                  lettercount++;
                  break;
                }
                else if (index ==6)
                {
                  a.drawString (guess,399,435);
                  lettercount++;
                  break;
                }
                else if (index ==7)
                {
                  a.drawString (guess,429,435);
                  lettercount++;
                  break;
                }
                else if (index ==8)
                {
                  a.drawString (guess,459,435);
                  lettercount++;
                  break;
                }
                else if (index ==9)
                {
                  a.drawString (guess,489,435);
                  lettercount++;
                  break;
                }
                else if (index ==10)
                {
                  a.drawString (guess,519,435);
                  lettercount++;
                  break;
                }
                else if (index ==11)
                {
                  a.drawString (guess,549,435);
                  lettercount++;
                  break;
                }
                else if (index ==12)
                {
                  a.drawString (guess,579,435);
                  lettercount++;
                  break;
                }
                else if (index == 13)
                {
                  a.drawString (guess, 609,435);
                  lettercount++;
                }
                else
                  c.print ("");
              }
              while (lettercount == (word.length ()));
            }
            else
            {
              
              break;
            }
          }
          if (count >= 1)
          {
            if ((index-1) == -1)
            {
              a.setFont (new Font ("Sansserif",Font.BOLD,40));
              a.setColor(Color.BLACK);
              strike++;
              if (strike == 1)
                a.fillOval(820,260,40,40);//head
              else if (strike == 2)
                a.drawString ("|",833,330);//body
              else if (strike == 3)
                a.drawString ("-",835,330);//first arm
              else if (strike == 4 )
                a.drawString ("-",822,330);//second arm
              else if (strike == 5)
                a.drawString("/",825,360);//first leg
              else if (strike == 6)
                a.drawString("|" ,833,359);//second leg also last chance
            }
          }
        }
      }
      
      if (strike >= 7) //hangman is dead
      {
        //This happens when its an L
        a.setFont (new Font ("Sansserif",Font.BOLD,15));
        a.setColor(Color.RED);
        a.drawString ("x x",830,278);
        a.drawString ("__",832,286);
        try        
        {
          Thread.sleep(1650);//delay animation in milliseconds
        } 
        catch(InterruptedException ex) 
        {
          Thread.currentThread().interrupt();
        }
        a.setTextBackgroundColor(Color.black);
        a.clear ();
        c.clear ();
        while (y != 200) // counted loop
        {
          
          a.setColor(Color.RED);
          a.setFont (new Font ("Sansserif",Font.BOLD,50));
          a.drawString ("Game Over",340,y);//blood dripping effect
          try        
          {
            Thread.sleep(3);//delay anamation in milliseconds
          } 
          catch(InterruptedException ex) 
          {
            Thread.currentThread().interrupt();
          }
          y--;
          c.setTextBackgroundColor(Color.white);
        }
        a.clear ();
        a.drawString ("Game Over",340,200);
        a.setFont (new Font ("Sansserif",Font.BOLD,20));
        a.setColor(Color.WHITE);
        a.drawString ("The word was: " + wordc,10, 340);
        a.setTextColor(Color.white);
        
        //Displays score and high score as well as setting a new high score if needed
        a.drawString ("Score for " + name + ": " + scorecount, 10,410);
        if (hi == -100 && low == 100)
        {
          hi = scorecount;
          low = scorecount;
        }
        else
        {
          
          if (scorecount > hi)
          {
            a.drawString ("New high score!",390,270);
            hi = scorecount;
          }
          else if (scorecount < low);
          {
            low = scorecount;
          }
          
        }
        
        a.drawString ("Highest score is :" + hi,10,390);
        a.drawString ("Would you like to quit?",355,230);//if you lose
        a.println ("Type 'no' to keep playing, otherwise enter anything else to quit");
        playagain= a.readLine ();
        
        if (playagain.equalsIgnoreCase("no"))
        {
          a.clear ();
        }
        else 
        {
          
          break;
        }
      }
      else if (correct == word.length ())
      {
        //This happens when its a W
        a.clear ();
        c.clear ();
        while (x != 200) // counted loop
        {
          a.clear ();
          a.setColor(Color.GREEN);//green colour for good
          a.setFont (new Font ("Sansserif",Font.BOLD,50));
          a.drawString ("Congratulations!",270,x);//flashing effect to show excitement
          try        
          {
            Thread.sleep(3);//delay animation in milliseconds
          } 
          catch(InterruptedException ex) 
          {
            Thread.currentThread().interrupt();
          }
          x--;
        }
        a.drawString ("Congratulations!",270,200);
        a.setFont (new Font ("Sansserif",Font.BOLD,20));
        a.drawString (wordc + " was the word, well done.",10, 340);
        a.setFont (new Font ("Sansserif",Font.BOLD,20));
        a.setColor(Color.BLACK);
         //Displays score and high score as well as setting a new high score if needed
        a.drawString ("Score for " + name + ": " + scorecount, 10,410);
        if (hi == -100 && low == 100)
        {
          hi = scorecount;
          low = scorecount;
        }
        else
        {
          
          if (scorecount > hi)
          {
            a.drawString ("New high score!",390,270);
            hi = scorecount;
          }
          else if (scorecount < low);
          {
            low = scorecount;
          }
          
        }
        a.drawString ("Highest score is: " +hi,10,390);
        
        
        a.drawString ("Would you like to quit?",360,230);//if you win
        a.println ("Type 'no' to keep playing, otherwise anything else to quit");
        playagain= a.readLine ();
        if (playagain.equalsIgnoreCase("no"))
        {
          a.clear ();
        }
        else 
        {
          break;
        }
      }
    }
    a.clear ();
    c.clear ();
    a.setFont (new Font ("Sansserif",Font.BOLD,50));
    a.drawString ("Thanks for Playing!",270,350);
    //summons the method with the gif this happens when the player quits for good so its infinite, good place for a gif
    new CPT ();
  } // end of main method
  private CPT () //seperate method for gif
  {
    int rep;
    rep =0;
    while (true)
    {
      
      String frame,frame2;
      frame = "frame1.jpg";
      frame2 = "frame2.jpg";
      //declares toolkit to grab appropriate file from hard drive
      Toolkit tk = Toolkit.getDefaultToolkit ();
      //each file will be displayed after another. Chooses file based on if it's odd or even since there are only 2 files. One might ask why not do it consecutively? Good idea
      if (rep % 2 == 0)
      {
        //[image = pic] see line 11 for declaration, image is pic, pic is file, file is fetched by toolkit command
        Pic = tk.getImage (frame2);
        try        
        {
          Thread.sleep(150);//delay animation in milliseconds
        } 
        catch(InterruptedException ex) 
        {
          Thread.currentThread().interrupt();
        }
      }
      else
      {
        Pic = tk.getImage (frame);
        try        
        {
          Thread.sleep(150);//delay animation in milliseconds
        } 
        catch(InterruptedException ex) 
        {
          Thread.currentThread().interrupt();
        }
        tk.prepareImage (Pic, -1, -1, this); //start loading the image
      }
      rep++;
    }
  }
  
  public boolean imageUpdate (Image img, int infoflags, int x, int y, int width, int height) //get details of image
  {
    
    if (infoflags == 32)
    {
      
      while (true)
      {
        
        c.drawImage (Pic, 16, 16, null);//Prints image
        try        
        {
          Thread.sleep(150);//delay animation in milliseconds
        } 
        catch(InterruptedException ex) 
        {
          Thread.currentThread().interrupt();
        }
      } 
    }
    return true;//Not unreachable code 
  }
}// HSATemplete class