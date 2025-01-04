public class ValueReceiver implements ButtonClickListener {
    @Override
    public void onButtonClicked(String value) {
        System.out.println("Button clicked, received value: " + value);
    }
}