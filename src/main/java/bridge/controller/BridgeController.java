package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        OutputView.start();
        OutputView.inputBridgeSize();

        bridgeGame.setUp(InputView.readBridgeSize());

        while(bridgeGame.isPlaying()) {
            OutputView.inputMoveDirection();
            if(!bridgeGame.move(InputView.readMoving())) {
                OutputView.inputRetry();
                if(bridgeGame.isFinish(InputView.readGameCommand())) {
                    break;
                } else {
                    bridgeGame.retry();
                }
            }
        }

        OutputView.printResult(bridgeGame.result());
    }
}
