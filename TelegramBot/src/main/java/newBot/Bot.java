package newBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import newBot.skills.Describe;
import newBot.skills.Participate;
import newBot.skills.Watch;

public class Bot extends TelegramLongPollingBot {
    private static final String TOKEN = "1806484776:AAFpfey2mS9uhxcotzpTxPoFLS7-7FdfTQ4";
    private static final String USERNAME = "NauchitsyaOsoznonnostyBot";
    //ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    public Bot() {}

    public String getBotUsername() {
        return USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void onUpdateReceived(Update update) {
        if(update.getMessage()!=null && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String chat_id = message.getChatId().toString();
            Watch watch = new Watch();
            Describe describe = new Describe();
            Participate participate = new Participate();

            switch (message.getText()) {
                case ("/start"):
                    try {
                        execute(new SendMessage(chat_id, "Привет!" +
                                "\nЯ бот, который поможет тебе тренировать навыки осознанности! " +
                                "\nЕсть три навыка осознанности: наблюдение, описание, участие. " +
                                "Чтобы тренировать случайный навык набери одну из команд : " +
                                "\n\n/наблюдать\n" +
                                "\n/описывать\n" +
                                "\n/участвовать\n" +
                                "\n\n и тренируй навык в течении нескольких минут." +
                                " Постарайся уделять этому время каждый день! Удачи!"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case ("/наблюдать"):
                    try {
                        execute(new SendMessage(chat_id, watch.getRandomWatch()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case ("/описывать"):
                    try {
                        execute(new SendMessage(chat_id, describe.getRandomDescribe()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case ("/участвовать"):
                    try {
                        execute(new SendMessage(chat_id, participate.getRandomParticipate()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        execute(new SendMessage(chat_id, "набери одну из команд : " +
                                "\n\n/наблюдать\n" +
                                "\n/описывать\n" +
                                "\n/участвовать"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

            }

        }
    }

    /*public static InlineKeyboardMarkup getInlineKeyBoard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("наблюдать");
        inlineKeyboardButton1.setCallbackData("watch");
        inlineKeyboardButton2.setText("описывать");
        inlineKeyboardButton2.setCallbackData("describe");
        inlineKeyboardButton3.setText("участвовать");
        inlineKeyboardButton3.setCallbackData("participate");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }*/
}
