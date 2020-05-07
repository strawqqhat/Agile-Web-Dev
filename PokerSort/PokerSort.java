import java.util.*;

    
public class PokerSort {
    
	static HashMap<Character, Integer> mmap = new HashMap<>();
    public static void main() {
       Character[] numberList = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
       int[] valueList = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
       HashMap<Character,Integer> map = new HashMap<Character,Integer>();
       for(int i=0; i<=13; i++) 
           map.put(numberList[i], valueList[i]); 
       mmap = map;
    }
    

    
  //是否是同花
    public static boolean isTonghua(List<Poker> pokers) {
        Character[] colors = new Character[5];
        Character[] numbers = new Character[5];
        for(int i=1; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        for(int i=1; i<pokers.size()-1; i++) {
            if(colors[i] != colors[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    
    //是否是铁支
    public static boolean isTiezhi(List<Poker> pokers) {
        Character[] colors = null;
        Character[] numbers = null;
        for(int i=0; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        int Count[] = new int[2];
        Count[0] = 1;
        Count[1] = 1;
        for(int i=2; i<pokers.size(); i++) {
            if(numbers[i] == numbers[0]) {
                Count[0]++;
            }
            if(numbers[i] == numbers[1]) {
                Count[1]++;
            }
        }
        if(Count[0] == 4 || Count[1] == 4) {
            return true;
        }else{
            return false;
        }
    }

    //是否是顺子
    public static boolean isShunzi(List<Poker> pokers) {
        Character[] colors = null;
        Character[] numbers = null;
        for(int i=0; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        int[] numbersInt = null;
        for(int i=0; i<pokers.size(); i++) {
            numbersInt[i] = mmap.get(pokers.get(i).number);
        }
        Arrays.sort(numbersInt);
        if(numbersInt[4]-numbersInt[0]==4) {
            return true;
        }
        return false;
        
    }

    //是否是三条
    public static boolean isSantiao(List<Poker> pokers) {
        Character[] colors = null;
        Character[] numbers = null;
        for(int i=0; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        int Count[] = new int[3];
        Count[0] = 1;
        Count[1] = 1;
        Count[2] = 1;
        for(int i=2; i<pokers.size(); i++) {
            if(numbers[i] == numbers[0]) {
                Count[0]++;
            }
            if(numbers[i] == numbers[1]) {
                Count[1]++;
            }
            if(numbers[i] == numbers[2]) {
                Count[2]++;
            }
        }
        if(Count[0] == 3 || Count[1] == 3 || Count[2] == 3) {
            return true;
        }else{
            return false;
        }
    }

    //是否是两对
    public static boolean isLiangdui(List<Poker> pokers) {
        Character[] colors = new Character[5];
        Character[] numbers = new Character[5];
        for(int i=1; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        int[] numbersInt = new int[5];
        for(int i=1; i<pokers.size(); i++) {
            numbersInt[i] = mmap.get(pokers.get(i).number);
        }
        Arrays.sort(numbersInt);
        int count = 0;
        for(int i=0; i<pokers.size()-1;) {
            if(numbersInt[i]==numbersInt[i+1]) {
                count++;
                i+=2;
                if(i>=pokers.size()-1) {
                    return false;
                }
            }
            i++;
        }
        if(count == 2) {
            return true;
        }
        return false;
    }

    //是否是对子
    public static boolean isDuizi(List<Poker> pokers) {
        Character[] colors = null;
        Character[] numbers = null;
        for(int i=0; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        int[] numbersInt = null;
        for(int i=0; i<pokers.size(); i++) {
            numbersInt[i] = mmap.get(pokers.get(i).number);
        }
        Arrays.sort(numbersInt);
        for(int i=1; i<pokers.size(); i++) {
            if(numbersInt[i] == numbersInt[i-1]) {
                return true;
            }
        }
        return false;
    }
    
    //是否是同花顺
    public static boolean isTonghuashun(List<Poker> pokers) {
        if(isTonghua(pokers)&&isShunzi(pokers)) {
            return true;
        }
        return false;
    }
    
    //是否是葫芦
    public static boolean isHulu(List<Poker> pokers) {
        Character[] colors = null;
        Character[] numbers = null;
        for(int i=0; i<pokers.size(); i++) {
            colors[i] = pokers.get(i).color;
            numbers[i] = pokers.get(i).number;
        }
        int[] numbersInt = null;
        for(int i=0; i<pokers.size(); i++) {
            numbersInt[i] = mmap.get(pokers.get(i).number);
        }
        Arrays.sort(numbersInt);
        int x = 1;
        int y = 1;
        for(int i=0; i<pokers.size()-1; i++) {
            if(numbersInt[i] == numbersInt[i+1]) {
                x++;
            }
            else {
                if(x >= 2) {
                    if(numbersInt[i] == numbersInt[i++]) {
                        y++;
                    }
                }
            }
        }
        if(x==2&&y==3||x==3&&y==2) {
            return true;
        }
        return false;
    }
	
    public static int PokerType(List<Poker>pokers){
        if(isTonghuashun(pokers)) {
            return 9;
        }
        if(isTiezhi(pokers)) {
            return 8;
        }
        if(isHulu(pokers)) {
            return 7;
        }
        if(isTonghua(pokers)) {
            return 6;
        }
        if(isShunzi(pokers)) {
            return 5;
        }
        if(isSantiao(pokers)) {
            return 4;
        }
        if(isLiangdui(pokers)) {
            return 3;
        }
        if(isDuizi(pokers)) {
            return 2;
        }
        return 1;
            
    }
    
    public static String compare(List<Poker> pokers1, List<Poker> pokers2) {
        if(PokerType(pokers1) == PokerType(pokers2)) {
            return "Tie";
        }
        else if(PokerType(pokers1) > PokerType(pokers2)) {
            return "White wins";
        }
        else if(PokerType(pokers1) < PokerType(pokers2)) {
            return "Black wins";
        }
        return null;
    }
}
