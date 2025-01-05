public class ValueReceiver implements ButtonClickListener {
    //此處的ValueReceiver(Class)繼承ButtonClickListener(介面)
    @Override
    public void onButtonClicked(int value) {
        //將Screen中按鈕傳出的數值送進Smartphone的run方法裡
        Smartphone phone = new Smartphone();
        phone.run(value);
    }
}