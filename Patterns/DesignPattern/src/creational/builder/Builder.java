class Message {
    private String sender;
    private String recipient;
    private String header;
    private String body;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return
                "Sender: " + sender + "\n" +
                "Recipient: " + recipient + "\n" +
                "Header: " + header + "\n" +
                "Body: " + body ;

    }
}

 abstract class MessageBuilder {
    protected Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void createMessage() {
        message = new Message();
    }

    public void constructMessage(){
        message = new Message();
    }

    public void constructSender(String sender){
        message.setSender(sender);
    }

    public void constructRecipient(String recipient){
        message.setRecipient(recipient);
    }

    public abstract void constructMessageHeader();
    public abstract void constructMessageBody(String body);
}

//build different mesages, e.g. SMSMessageBuilder and MMSMessageBuilder

class SMSMessageBuilder extends MessageBuilder {

    public void constructMessageHeader() {
        message.setHeader("SMS header");
    }

    public void constructMessageBody(String body) {
        message.setBody(body);
    }
}

class MMSMessageBuilder extends MessageBuilder {

    public void constructMessageHeader() {
       message.setHeader("MMS header");
    }

    public void constructMessageBody(String body) {
       message.setBody(body);
    }
}

//ContentProvider class creates the required message using the relevant builder

class ContentProvider {

    private MessageBuilder messageBuilder;

    public MessageBuilder getMessageBuilder() {
        return messageBuilder;
    }

    public void setMessageBuilder(MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }

    public Message getMessage() {
        return messageBuilder.getMessage();
    }

    public Message createMessage(
            MessageBuilder messageBuilder,
            String sender,
            String recipient,
            String message) {
        messageBuilder.constructMessage();
        messageBuilder.constructSender(sender);
        messageBuilder.constructRecipient(recipient);
        messageBuilder.constructMessageHeader();
        messageBuilder.constructMessageBody(message);
        return messageBuilder.getMessage();
    }
}


public class Builder {

    public static void main(String[] args){
        ContentProvider contentProvider = new ContentProvider();
        MessageBuilder smsMessageBuilder = new SMSMessageBuilder();
        MessageBuilder mmsMessageBuilder = new MMSMessageBuilder();

        Message sms =
           contentProvider.createMessage(
             smsMessageBuilder, "1234", "5678", "SMS message");
        Message mms =
           contentProvider.createMessage(
             mmsMessageBuilder, "1234", "5678", "MMS message");

        System.out.println(sms.toString());
        System.out.println(mms.toString());
    }
}
