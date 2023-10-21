package ru.job4j.chess;


import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() throws ImpossibleMoveException {

        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.G5);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void whenMoveThenOccupiedCellException() throws OccupiedCellException {
        Logic logic = new Logic();
        Exception exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.G6);
        });
        assertThat(exception.getMessage()).isEqualTo("the Cell is occupied");
    }

    @Test
    void whenMoveThenImpossibleMoveException() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(bishopBlack.position(), Cell.G6);
        });
        assertThat(exception.getMessage()).isEqualTo((String.format(
                "Could not way by diagonal from %s to %s", Cell.C1, Cell.G5)));
    }
}
