package ru.shadam.tg.enitity.util;

/**
 * @author sala
 */
public class ResultWrapper<T> {
    private boolean ok;
    private T result;

    public ResultWrapper(boolean ok, T result) {
        this.ok = ok;
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public T getResult() {
        return result;
    }


    @Override
    public String toString() {
        return "ResultWrapper{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
