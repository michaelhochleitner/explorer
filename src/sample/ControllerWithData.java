package sample;

public class ControllerWithData {

    Data data;

    protected void initModel(Data data){
        if (this.data != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.data = data;
    }
}
