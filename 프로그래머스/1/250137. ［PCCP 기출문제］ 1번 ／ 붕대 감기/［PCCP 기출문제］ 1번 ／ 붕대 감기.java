import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = attacks[attacks.length - 1][0];
        int [] situ = new int [time + 1];
        int conti = 0; //연속 성공 체크 
        int maxhealth = health;
        for (int i = 0; i < situ.length; i++){
            boolean at = true;
            for (int j = 0; j < attacks.length; j++){
                if (attacks[j][0] == i){
                    health -= attacks[j][1];
                    at = !at;
                    conti = 0;
                }
            } //공격 당할때
            if (at) { //공격이 없을때 
                conti++;
                health += bandage[1];
                if (conti == bandage[0]){ //연속 성공
                    health += bandage[2];
                    conti = 0;
                }
            }
            if (health >= maxhealth) //최대체력이상 커지는것 불가능
                health = maxhealth;
            if (health <= 0) //만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return -> 테케 3번
                return -1;
            situ[i] = health;
        }
        if (health <= 0)
            return -1;
        return health;
    }
}