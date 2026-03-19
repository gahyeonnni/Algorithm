import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int [][] array;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static StringTokenizer st;
    static int n;
    static int sum = 0;

    private static void makeSum(Map<Integer, List<Integer>> map, int [][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = array[i][j];
                List<Integer> studnetList = map.get(student);
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int i1 = i + dx[k];
                    int j1 = j + dy[k];

                    if (i1 >= 0 && j1 >= 0 && i1 < n && j1 < n) {
                        int another = array[i1][j1];
                        if (studnetList.contains(another)) {
                            count++;
                        }
                    }
                }
                checkCount(count);
            }
        }
    }

    private static void checkCount(int count) {
        if (count == 0)
            sum += 0;
        else if (count == 1)
            sum += 1;
        else if (count == 2)
            sum += 10;
        else if (count == 3)
            sum += 100;
        else
            sum += 1000;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int like1 = Integer.parseInt(st.nextToken());
            int like2 = Integer.parseInt(st.nextToken());
            int like3 = Integer.parseInt(st.nextToken());
            int like4 = Integer.parseInt(st.nextToken());
            map.put(a, new ArrayList<>(List.of(like1, like2, like3, like4)));
        }

        List<Integer> existPeople = new ArrayList<>();

        for (int student : map.keySet()) {
            List<Integer> list = map.get(student);

            if (existPeople.isEmpty() || !checkExist(existPeople, list)) {
                Map<Integer, List<int[]>> emptyRoom = new LinkedHashMap<>();
                findEmptyRooms(emptyRoom, array);

                List<Integer> keyList = new ArrayList<>(emptyRoom.keySet());
                keyList.sort(Collections.reverseOrder());
                int max = keyList.get(0);
                List<int[]> getMaxEmptyCount = emptyRoom.get(max);

                if (getMaxEmptyCount.size() == 1) {
                    int[] first = getMaxEmptyCount.get(0);
                    int f1 = first[0];
                    int f2 = first[1];
                    array[f1][f2] = student;
                    existPeople.add(student);
                } else {
                    Collections.sort(getMaxEmptyCount, (a, b) -> {
                        if (a[0] == b[0])
                            return a[1] - b[1];
                        return a[0] - b[0];
                    });
                    int[] first = getMaxEmptyCount.get(0);
                    int f1 = first[0];
                    int f2 = first[1];
                    array[f1][f2] = student;
                    existPeople.add(student);
                }
            } else {
                Map<Integer, List<int[]>> likePersons = new LinkedHashMap<>();
                findLikePerson(list, array, likePersons);

                List<Integer> keyList = new ArrayList<>(likePersons.keySet());
                keyList.sort(Collections.reverseOrder());
                int max = keyList.get(0);
                List<int[]> likePerson = likePersons.get(max);

                if (likePerson.size() == 1) {
                    int[] first = likePerson.get(0);
                    int f1 = first[0];
                    int f2 = first[1];
                    array[f1][f2] = student;
                    existPeople.add(student);
                } else {
                    Map<Integer, List<int[]>> emptyRooms = new LinkedHashMap<>();
                    for (int[] x : likePerson) {
                        int x1 = x[0];
                        int x2 = x[1];
                        findEmptyRoom(emptyRooms, array, x1, x2);
                    }

                    List<Integer> keys = new ArrayList<>(emptyRooms.keySet());
                    keys.sort(Collections.reverseOrder());
                    int max1 = keys.get(0);
                    List<int[]> getMin = emptyRooms.get(max1);

                    if (getMin.size() == 1) {
                        int[] first = getMin.get(0);
                        int f1 = first[0];
                        int f2 = first[1];
                        array[f1][f2] = student;
                        existPeople.add(student);
                    } else {
                        Collections.sort(getMin, (a, b) -> {
                            if (a[0] == b[0])
                                return a[1] - b[1];
                            return a[0] - b[0];
                        });
                        int[] first = getMin.get(0);
                        int f1 = first[0];
                        int f2 = first[1];
                        array[f1][f2] = student;
                        existPeople.add(student);
                    }
                }
            }
        }

        makeSum(map, array);
        System.out.println(sum);
    }

    private static void findLikePerson(List<Integer> list, int [][] array, Map<Integer, List<int[]>> likePersons) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 0)
                    continue;

                int likePerson = 0;
                for (int k = 0; k < 4; k++) {
                    int i1 = i + dx[k];
                    int j1 = j + dy[k];
                    if (i1 >= 0 && j1 >= 0 && i1 < n && j1 < n) {
                        if (list.contains(array[i1][j1]))
                            likePerson++;
                    }
                }

                if (!likePersons.containsKey(likePerson)) {
                    likePersons.put(likePerson, new ArrayList<>(List.of(new int[] {i, j})));
                } else {
                    likePersons.get(likePerson).add(new int[] {i, j});
                }
            }
        }
    }

    private static void findEmptyRoom(Map<Integer, List<int[]>> emptyRoom, int [][] array, int a, int b) {
        if (array[a][b] != 0)
            return;

        int emptyCount = 0;
        for (int k = 0; k < 4; k++) {
            int i1 = a + dx[k];
            int j1 = b + dy[k];
            if (i1 >= 0 && j1 >= 0 && i1 < n && j1 < n) {
                if (array[i1][j1] == 0)
                    emptyCount++;
            }
        }

        if (!emptyRoom.containsKey(emptyCount)) {
            emptyRoom.put(emptyCount, new ArrayList<>(List.of(new int[] {a, b})));
        } else {
            emptyRoom.get(emptyCount).add(new int[] {a, b});
        }
    }

    private static void findEmptyRooms(Map<Integer, List<int[]>> emptyRoom, int [][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 0)
                    continue;

                int emptyCount = 0;
                for (int k = 0; k < 4; k++) {
                    int i1 = i + dx[k];
                    int j1 = j + dy[k];
                    if (i1 >= 0 && j1 >= 0 && i1 < n && j1 < n) {
                        if (array[i1][j1] == 0)
                            emptyCount++;
                    }
                }

                if (!emptyRoom.containsKey(emptyCount)) {
                    emptyRoom.put(emptyCount, new ArrayList<>(List.of(new int[] {i, j})));
                } else {
                    emptyRoom.get(emptyCount).add(new int[] {i, j});
                }
            }
        }
    }

    private static boolean checkExist(List<Integer> existPeople, List<Integer> list) {
        for (int a : list) {
            if (existPeople.contains(a))
                return true;
        }
        return false;
    }
}