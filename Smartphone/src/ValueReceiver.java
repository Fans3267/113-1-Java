public class ValueReceiver implements ButtonClickListener {
    @Override
    public void onButtonClicked(int value) {
        Smartphone phone = new Smartphone();
        phone.run(value);
    }
}