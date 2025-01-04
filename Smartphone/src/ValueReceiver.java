public class ValueReceiver implements ButtonClickListener {
    @Override
    public void onButtonClicked(int value) {
        System.out.println("Button clicked, received value: " + value);
    }
}