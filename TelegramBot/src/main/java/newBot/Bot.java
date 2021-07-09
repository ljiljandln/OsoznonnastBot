package newBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import newBot.skills.Describe;
import newBot.skills.Participate;
import newBot.skills.Watch;

import java.util.ArrayList;
import java.util.List;

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
        Watch watch = new Watch();
        Describe describe = new Describe();
        Participate participate = new Participate();
        if(update.getMessage()!=null && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String chat_id = message.getChatId().toString();

            switch (message.getText()) {
                case ("/start"):
                    try {
                        SendMessage sendMessage = new SendMessage(chat_id, "Привет!" +
                                "\nЯ бот, который поможет тебе тренировать навыки осознанности! " +
                                "\nЕсть три навыка осознанности: наблюдать, описывать, участвовать. " +
                                "Выбери в меню снизу тип навыка, который ты хочешь тренировать, и тренируй его в течении нескольких минут." +
                                " Постарайся уделять этому время каждый день! Удачи!");
                        sendMessage.setReplyMarkup(getInlineKeyBoard());
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        SendMessage sendMessage = new SendMessage(chat_id, "В меню снизу выбери навык, который хочешь тренировать");
                        sendMessage.setReplyMarkup(getInlineKeyBoard());
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

            }

        }
        if (update.hasCallbackQuery()) {
            String chat_id = update.getCallbackQuery().getMessage().getChatId().toString();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            if(callbackQuery.getData().equals("watch")) {
                try {
                    execute(new SendMessage(chat_id, watch.getRandomWatch()));

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(callbackQuery.getData().equals("describe")) {
                try {
                    execute(new SendMessage(chat_id, describe.getRandomDescribe()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(callbackQuery.getData().equals("participate")) {
                try {
                    execute(new SendMessage(chat_id, participate.getRandomParticipate()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            try {
                SendMessage sendMessage = new SendMessage(chat_id, "выбрать другой навык");
                sendMessage.setReplyMarkup(getInlineKeyBoard());
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public static InlineKeyboardMarkup getInlineKeyBoard() {
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
    }
}
