package bridge.controller;

import java.util.function.BooleanSupplier;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        start();
        getBridgeSize();
        playing();
        finish();
    }

    private static void start() {
        OutputView.start();
    }

    private void getBridgeSize() {
        OutputView.inputBridgeSize();
        process(() -> bridgeGame.setUp(InputView.readBridgeSize()));
    }

    private void process(Runnable runnable) {
        while(true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public void playing() {
        while(bridgeGame.isPlaying()) {
            OutputView.inputMoveDirection();
            boolean result = getResult();

            OutputView.printMap(bridgeGame.map());
            if (isRetry(result)) {
                break;
            }
        }
    }

    private boolean isRetry(boolean result) {
        if(!result) {
            OutputView.inputRetry();
            boolean restart = getRestart();
            if(restart) {
                return true;
            } else {
                bridgeGame.retrySetUp();
            }
        }
        return false;
    }

    private boolean getRestart() {
        return processWithReturn(() -> InputView.readGameCommand().getRestart());
    }

    private boolean getResult() {
        return processWithReturn(() -> bridgeGame.move(InputView.readMoving()));
    }

    private boolean processWithReturn(BooleanSupplier supplier) {
        while(true) {
            try {
                return supplier.getAsBoolean();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void finish() {
        OutputView.finalResult();
        OutputView.printMap(bridgeGame.map());
        OutputView.printResult(bridgeGame.result());
    }
}
