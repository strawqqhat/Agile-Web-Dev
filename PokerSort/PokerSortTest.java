import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PokerSortTest2 {

    @SuppressWarnings("null")
    @Test
    public void testIsTonghua() {
        String[] zhipais = {"2H", "3H", "4H", "5H", "6H"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            Poker poker = new Poker(color, number);
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isTonghua(pokers));
    }

    @Test
    public void testIsTiezhi() {
        String[] zhipais = {"2H", "2D", "2S", "2C", "KD"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isTiezhi(pokers));
    }

    @Test
    public void testIsShunzi() {
        String[] zhipais = {"2H", "3D", "4S", "5C", "6D"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isShunzi(pokers));
    }

    @Test
    public void testIsSantiao() {
        String[] zhipais = {"2H", "2D", "2S", "9C", "KD"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isSantiao(pokers));
    }

    @Test
    public void testIsLiangdui() {
        String[] zhipais = {"2H", "2D", "5S", "5C", "2S"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isLiangdui(pokers));
    }

    @Test
    public void testIsDuizi() {
        String[] zhipais = {"2H", "2D", "5S", "9C", "KD"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isDuizi(pokers));
    }

    @Test
    public void testIsTonghuashun() {
        String[] zhipais = {"2H", "3H", "4H", "5H", "6H"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isTonghuashun(pokers));
    }

    @Test
    public void testIsHulu() {
        String[] zhipais = {"2H", "2D", "2S", "4C", "4D"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(true,PokerSort.isHulu(pokers));
    }

    @Test
    public void testPokerType() {
        String[] zhipais = {"2H", "3D", "5S", "9C", "KD"};
        List<Poker> pokers = new ArrayList<Poker>();
        for(int i=0; i<zhipais.length; i++) {
            Poker poker = null;
            char number = zhipais[i].charAt(0);
            char color = zhipais[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers.add(poker);
            
        }
        assertEquals(1,PokerSort.PokerType(pokers));
    }

    @Test
    public void testCompare() {
        String[] zhipais1 = {"2H", "3D", "5S", "9C", "KD"};
        String[] zhipais2 = {"2D", "3H", "5C", "9H", "KH"};
        List<Poker> pokers1 = new ArrayList<Poker>();
        List<Poker> pokers2 = new ArrayList<Poker>();
        for(int i=0; i<zhipais1.length; i++) {
            Poker poker = null;
            char number = zhipais1[i].charAt(0);
            char color = zhipais1[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers1.add(poker);
            
        }
        for(int i=0; i<zhipais2.length; i++) {
            Poker poker = null;
            char number = zhipais2[i].charAt(0);
            char color = zhipais2[i].charAt(1);
            poker.number = number;
            poker.color = color;
            pokers2.add(poker);
            
        }
        assertEquals("Tie",PokerSort.compare(pokers1, pokers2));
    }

}
