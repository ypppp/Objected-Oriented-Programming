package game;

import edu.monash.fit2099.engine.displays.Display;

import java.util.HashMap;

/**
 * Fancy messages used to print the game title
 * Font obtained from: <a href="https://patorjk.com/software/taag/#p=display&f=Georgia11&t=">...</a>
 * Font: Georgia11
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 */
public class FancyMessage {


    /**
     * The fancy message for elden ring
     */
    public static String ELDEN_RING =
            "`7MM\"\"\"YMM  `7MMF'      `7MM\"\"\"Yb. `7MM\"\"\"YMM  `7MN.   `7MF'    `7MM\"\"\"Mq.  `7MMF'`7MN.   `7MF' .g8\"\"\"bgd  \n" +
            "  MM    `7    MM          MM    `Yb. MM    `7    MMN.    M        MM   `MM.   MM    MMN.    M .dP'     `M  \n" +
            "  MM   d      MM          MM     `Mb MM   d      M YMb   M        MM   ,M9    MM    M YMb   M dM'       `  \n" +
            "  MMmmMM      MM          MM      MM MMmmMM      M  `MN. M        MMmmdM9     MM    M  `MN. M MM           \n" +
            "  MM   Y  ,   MM      ,   MM     ,MP MM   Y  ,   M   `MM.M        MM  YM.     MM    M   `MM.M MM.    `7MMF'\n" +
            "  MM     ,M   MM     ,M   MM    ,dP' MM     ,M   M     YMM        MM   `Mb.   MM    M     YMM `Mb.     MM  \n" +
            ".JMMmmmmMMM .JMMmmmmMMM .JMMmmmdP' .JMMmmmmMMM .JML.    YM      .JMML. .JMM..JMML..JML.    YM   `\"bmmmdPY  \n";

    /**
     * The fancy message for when the player dies
     */
    public static String YOU_DIED =
            "`YMM'   `MM' .g8\"\"8q. `7MMF'   `7MF'    `7MM\"\"\"Yb. `7MMF'`7MM\"\"\"YMM  `7MM\"\"\"Yb.   \n" +
            "  VMA   ,V .dP'    `YM. MM       M        MM    `Yb. MM    MM    `7    MM    `Yb. \n" +
            "   VMA ,V  dM'      `MM MM       M        MM     `Mb MM    MM   d      MM     `Mb \n" +
            "    VMMP   MM        MM MM       M        MM      MM MM    MMmmMM      MM      MM \n" +
            "     MM    MM.      ,MP MM       M        MM     ,MP MM    MM   Y  ,   MM     ,MP \n" +
            "     MM    `Mb.    ,dP' YM.     ,M        MM    ,dP' MM    MM     ,M   MM    ,dP' \n" +
            "   .JMML.    `\"bmmd\"'    `bmmmmd\"'      .JMMmmmdP' .JMML..JMMmmmmMMM .JMMmmmdP'   \n";

    public static String DISCOVERED =
            "\n" +
                    "                                                                                                                                                                                                                                     \n" +
                    "                                                                                                                                                                                                                                     \n" +
                    "`7MMF'        .g8\"\"8q.    .M\"\"\"bgd MMP\"\"MM\"\"YMM       .g8\"\"\"bgd `7MM\"\"\"Mq.        db       .g8\"\"\"bgd `7MM\"\"\"YMM      `7MM\"\"\"Yb. `7MMF' .M\"\"\"bgd   .g8\"\"\"bgd   .g8\"\"8q.`7MMF'   `7MF'`7MM\"\"\"YMM  `7MM\"\"\"Mq.  `7MM\"\"\"YMM  `7MM\"\"\"Yb.   \n" +
                    "  MM        .dP'    `YM. ,MI    \"Y P'   MM   `7     .dP'     `M   MM   `MM.      ;MM:    .dP'     `M   MM    `7        MM    `Yb. MM  ,MI    \"Y .dP'     `M .dP'    `YM.`MA     ,V    MM    `7    MM   `MM.   MM    `7    MM    `Yb. \n" +
                    "  MM        dM'      `MM `MMb.          MM          dM'       `   MM   ,M9      ,V^MM.   dM'       `   MM   d          MM     `Mb MM  `MMb.     dM'       ` dM'      `MM VM:   ,V     MM   d      MM   ,M9    MM   d      MM     `Mb \n" +
                    "  MM        MM        MM   `YMMNq.      MM          MM            MMmmdM9      ,M  `MM   MM            MMmmMM          MM      MM MM    `YMMNq. MM          MM        MM  MM.  M'     MMmmMM      MMmmdM9     MMmmMM      MM      MM \n" +
                    "  MM      , MM.      ,MP .     `MM      MM          MM.    `7MMF' MM  YM.      AbmmmqMA  MM.           MM   Y  ,       MM     ,MP MM  .     `MM MM.         MM.      ,MP  `MM A'      MM   Y  ,   MM  YM.     MM   Y  ,   MM     ,MP \n" +
                    "  MM     ,M `Mb.    ,dP' Mb     dM      MM          `Mb.     MM   MM   `Mb.   A'     VML `Mb.     ,'   MM     ,M       MM    ,dP' MM  Mb     dM `Mb.     ,' `Mb.    ,dP'   :MM;       MM     ,M   MM   `Mb.   MM     ,M   MM    ,dP' \n" +
                    ".JMMmmmmMMM   `\"bmmd\"'   P\"Ybmmd\"     .JMML.          `\"bmmmdPY .JMML. .JMM..AMA.   .AMMA. `\"bmmmd'  .JMMmmmmMMM     .JMMmmmdP' .JMML.P\"Ybmmd\"    `\"bmmmd'    `\"bmmd\"'      VF      .JMMmmmmMMM .JMML. .JMM..JMMmmmmMMM .JMMmmmdP'   \n" +
                    "                                                                                                                                                                                                                                     \n" +
                    "                                                                                                                                                                                                                                     \n" +
                    "\n";
    /**
     * Fancy message when the player go to limgrave
     */
    public static String LIMGRAVE =
                    "              ,,                                                               \n"+
                    "`7MMF'        db                     .g8\"\"\"bgd                                   \n"+
                    "  MM                               .dP'     `M                                   \n"+
                    "  MM        `7MM  `7MMpMMMb.pMMMb. dM'       ` `7Mb,od8 ,6\"Yb.`7M'   `MF'.gP\"Ya \n"+
                    "  MM          MM    MM    MM    MM MM            MM' \"'8)   MM  VA   ,V ,M'   Yb \n"+
                    "  MM      ,   MM    MM    MM    MM MM.    `7MMF' MM     ,pm9MM   VA ,V  8M\"\"\"\"\"\" \n"+
                    "  MM     ,M   MM    MM    MM    MM `Mb.     MM   MM    8M   MM    VVV   YM.    , \n"+
                    ".JMMmmmmMMM .JMML..JMML  JMML  JMML. `\"bmmmdPY .JMML.  `Moo9^Yo.   W     `Mbmmd' \n"+
                    "                                                                                  \n"+
                    "\n";

    /**
     * Fancy message when the player go to roundtable
     */
    public static String ROUNDTABLE_HOLD =
            "                                                 ,,                   ,,        ,,          \n"+
            "`7MM\"\"\"Mq.                                     `7MM MMP\"\"MM\"\"YMM     *MM      `7MM         \n"+
            "  MM   `MM.                                      MM P'   MM   `7      MM        MM          \n"+
            "  MM   ,M9  ,pW\"Wq.`7MM  `7MM  `7MMpMMMb.   ,M\"\"bMM      MM   ,6\"Yb.  MM,dMMb.  MM  .gP\"Ya  \n"+
            "  MMmmdM9  6W'   `Wb MM    MM    MM    MM ,AP    MM      MM  8)   MM  MM    `Mb MM ,M'   Yb \n"+
            "  MM  YM.  8M     M8 MM    MM    MM    MM 8MI    MM      MM   ,pm9MM  MM     M8 MM 8M\"\"\"\"\"\" \n"+
            "  MM   `Mb.YA.   ,A9 MM    MM    MM    MM `Mb    MM      MM  8M   MM  MM.   ,M9 MM YM.    , \n"+
            ".JMML. .JMM.`Ybmd9'  `Mbod\"YML..JMML  JMML.`Wbmd\"MML.  .JMML.`Moo9^Yo.P^YbmdP'.JMML.`Mbmmd' \n"+
            "                                                                                              \n"+
            "\n";


    /**
     * Fancy message when the player go to storm veil castle
     */
    public static String STORMVEILCASTLE =
            "                                                                 ,,    ,,                                      ,,         \n"+
            " .M\"\"\"bgd mm                                `7MMF'   `7MF'       db  `7MM   .g8\"\"\"bgd                   mm   `7MM         \n"+
            ",MI    \"Y MM                                  `MA     ,V               MM .dP'     `M                   MM     MM         \n"+
            "`MMb.   mmMMmm ,pW\"Wq.`7Mb,od8 `7MMpMMMb.pMMMb.VM:   ,V .gP\"Ya `7MM    MM dM'       ` ,6\"Yb.  ,pP\"Ybd mmMMmm   MM  .gP\"Ya \n"+
            "  `YMMNq. MM  6W'   `Wb MM' \"'   MM    MM    MM MM.  M',M'   Yb  MM    MM MM         8)   MM  8I   `\"   MM     MM ,M'   Yb\n"+
            ".     `MM MM  8M     M8 MM       MM    MM    MM `MM A' 8M\"\"\"\"\"\"  MM    MM MM.         ,pm9MM  `YMMMa.   MM     MM 8M\"\"\"\"\"\" "+
            "Mb     dM MM  YA.   ,A9 MM       MM    MM    MM  :MM;  YM.    ,  MM    MM `Mb.     ,'8M   MM  L.   I8   MM     MM YM.    , \n"+
            "P\"Ybmmd\"  `Mbmo`Ybmd9'.JMML.   .JMML  JMML  JMML. VF    `Mbmmd'.JMML..JMML. `\"bmmmd' `Moo9^Yo.M9mmmP'   `Mbmo.JMML.`Mbmmd' \n"+
            "                                                                                                                              \n"+
            "\n";

    /**
     * A hashmap to link the map name to the fancy message
     */
    public static HashMap<String, String> fancyMsgMap = new HashMap<String, String>() {{
        put("Limgrave",FancyMessage.LIMGRAVE);
        put("The First Step",FancyMessage.LIMGRAVE);
        put("Table of Lost Grace",FancyMessage.ROUNDTABLE_HOLD);
        put("Roundtable Hold", FancyMessage.ROUNDTABLE_HOLD);
        put("StormVeil Castle", FancyMessage.STORMVEILCASTLE);
        put("Stormveil Main Gate",FancyMessage.STORMVEILCASTLE);
    }};

    public static void printMessage(String message){
        for (String line : FancyMessage.fancyMsgMap.get(message).split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}


