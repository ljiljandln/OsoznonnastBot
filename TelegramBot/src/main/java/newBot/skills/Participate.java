package newBot.skills;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Participate {
    private List<String> participateList = new ArrayList<>();
    {
        participateList.add("Танцуйте под музыку");
        participateList.add("Подпевайте музыке, которую слушаете");
        participateList.add("Пойте в душе");
        participateList.add("Вскакивайте с кровати, танцуйте и пойте, пока не оденетесь");
        participateList.add("Идите туда, где поют и присоединяйтесь к пению");
        participateList.add("Пойте в караоке, клубе, баре со своими друзьями");
        participateList.add("Вникайте в те слова, которые вам говорят другие");
        participateList.add("Бегайте, концентриируясь на беге");
        participateList.add("Занимайтесь спортом, погружаясь в него");
        participateList.add("Считайте количество вдохов и выдохов");
        participateList.add("Осознавайте каждое слово, которое вы произносите");
        participateList.add("Сфокусируйте своё внимание на том, до чего вы дотрагиваетесь (пол или земля, стул или подлокотник, ваши простыни или покрывала на кровати, ваша одежда, др.). Постарайтесь увидеть все возможные способы вашей связи (вашего контакта) с предметом. Подумайте над той функцией, которую выполняет данный предмет для вас. Подумайте, что для вас значит этот предмет. Подумайте, какую пользу он приносит. Изучите те ощущения, которые вызывает у вас соприкосновение с этим предметом, и перенесите всё своё внимание на чувства, которые вы испытываете, пока не осознаете свою связь с предметом или ваше взаимное тёплое отношение.");
    }

    public String getRandomParticipate() {
        Random random = new Random();
        return participateList.get(random.nextInt(participateList.size()));
    }
}
