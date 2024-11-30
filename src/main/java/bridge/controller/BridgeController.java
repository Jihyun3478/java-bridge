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
            boolean result = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.map());
            if(!result) {
                OutputView.inputRetry();
                if(bridgeGame.isFinish(InputView.readGameCommand())) {
                    break;
                } else {
                    bridgeGame.retrySetUp();
                }
            }
        }

        OutputView.printResult(bridgeGame.result());
    }
}
