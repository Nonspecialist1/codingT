package programers.leveltwo;

public class Kakao_String_Minimize {

    public static void main(String[] args) {
        String s = "aabbaccc";
        int ans = s.length();

        // 1개부터 문자열 길이의 절반까지 압축 검사
        for(int unit=1; unit<=s.length() / 2; unit++){
            int same = 1; // 같은 갯수
            String fir = s.substring(0, unit);
            StringBuilder sb = new StringBuilder();

            for(int idx=unit; idx<=s.length(); idx+=unit){
                String sec = s.substring(idx, idx + unit > s.length() ? s.length() : idx + unit); // 다음문자 추출

                if(fir.equals(sec)) same++;
                else {
                    sb.append((same != 1 ? same : "") + fir);
                    fir = sec;
                    same = 1;
                }
            }
            sb.append(fir);
            ans = Math.min(ans, sb.length());
        }

        System.out.println(ans);
    }
}
