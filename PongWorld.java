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
        Map<Integer, Map<String, String>> allLevelsJSON;

        /**
         * Constructor for objects of class PongWorld.
         * 
         */
        public PongWorld()
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            super(600, 600, 1);
            this.allLevelsJSON = new HashMap<Integer, Map<String, String>>();
            populate();
        }
        
        private void populate() {
            String dateiName = "levels.txt";
            this.allLevelsJSON = ladeDatei(dateiName);
            
            generateLevel();
            Player leftPlayer = new Player("up", "down");
            Player rightPlayer = new Player("w", "s");
            Ball ball = new Ball(leftPlayer, rightPlayer);
            
            addObject(leftPlayer, 40, this.screenHeight/2);
            addObject(rightPlayer, this.screenWidth-40, this.screenHeight/2);
            addObject(ball, this.screenWidth/2, this.screenHeight/2);

        }
        
        private void generateLevel() {
            
        }
        
        private Map<Integer, Map<String, String>> ladeDatei(String datName) { 

            BufferedReader in = null;
            
            Map<Integer, Map<String, String>> allLevelsJSON = new HashMap<Integer, Map<String, String>>();
            Map<Integer, String> allLevelsString = new HashMap<Integer, String>();
            
            try { 
                in = new BufferedReader(new FileReader(datName)); 
                String zeile = null;
                int level = 0;
                StringBuilder builder = new StringBuilder();
    
                while ((zeile = in.readLine()) != null) {
                    if (zeile.equals("") || zeile.equals("ende")) {
                        allLevelsString.put(level, builder.toString());
                        builder.delete(0, builder.length());
                        level++;
                    } else {
                        String[] split = zeile.split("=");
                        builder.append(split[0]+":"+split[1]+"/");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try { 
                        in.close(); 
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    
            for (int i = 0; i < allLevelsString.size(); i++) {
                String currentString = allLevelsString.get(i);
                Map<String, String> currentLevelJSON = new HashMap<String, String>();
    
                String[] allKeysAndVals = currentString.split("/");
    
                for (int j = 0; j < allKeysAndVals.length; j++) {
                    String[] currentKeyAndVal = allKeysAndVals[j].split(":");
                    currentLevelJSON.put(currentKeyAndVal[0], currentKeyAndVal[1]);
                }
    
                allLevelsJSON.put(i, currentLevelJSON);
            }
    
            return allLevelsJSON;
        }
    }









