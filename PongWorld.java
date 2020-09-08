    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    import java.io.BufferedReader; 
    import java.io.File; 
    import java.io.FileReader; 
    import java.io.IOException;

    import java.util.Map;
    import java.util.HashMap;
    
    /**
     * Write a description of class PongWorld here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class PongWorld extends World
    {
    
        private int screenHeight = 600;
        private int screenWidth = 600;
        /**
         * Constructor for objects of class PongWorld.
         * 
         */
        public PongWorld()
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            super(600, 600, 1); 
            populate();
        }
        
        private void populate() {
            Player leftPlayer = new Player("up", "down");
            Player rightPlayer = new Player("w", "s");
            Ball ball = new Ball(leftPlayer, rightPlayer);
            
            addObject(leftPlayer, 40, this.screenHeight/2);
            addObject(rightPlayer, this.screenWidth-40, this.screenHeight/2);
            addObject(ball, this.screenWidth/2, this.screenHeight/2);

            String dateiName = "levels.txt"; 
            ladeDatei(dateiName); 
        }
        
        private void ladeDatei(String datName) { 

            File file = new File(datName);
            BufferedReader in = null;
            
            Map<Integer, Map<String, String>> levels = new HashMap<Integer, Map<String, String>>();
            
            try { 
                in = new BufferedReader(new FileReader(datName)); 
                String zeile = null;
                StringBuilder builder = new StringBuilder();
                int level = 0;
                Map<String, String> currentLevel = new HashMap<String, String>();
                while ((zeile = in.readLine()) != null) {
                    if (zeile.equals("")) {
                        if (level > 0) {
                            levels.put(level, currentLevel);
                            currentLevel.clear();
                        }
                        level++;
                    } else {
                        String[] splits = zeile.split("=");
                        String key = splits[0];
                        String value = splits[1];
                        currentLevel.put(key, value);
                    }
                }
                System.out.println(levels);
            } catch (IOException e) {
                System.out.println(e);
            } finally { 
                if (in != null) {
                    try { 
                        in.close(); 
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }









