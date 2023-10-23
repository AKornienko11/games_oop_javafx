package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

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
    void whenMoveThenImpossibleMoveException() throws ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure[] figures = new Figure[]{null, null, bishopBlack};
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.G6);
        });
        assertThat(exception.getMessage()).isEqualTo((String.format(
                "Could not way by diagonal from %s to %s", Cell.C1, Cell.G6)));
    }

    @Test
    void whenMoveOccupiedCellException() throws OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        KingBlack kingBlack = new KingBlack(Cell.F4);
        Cell[] steps = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Figure[] figures = new Figure[]{null, null, bishopBlack};
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.G5);
        });
        assertThat(exception.getMessage()).isEqualTo((String.format(
                "Could not way by diagonal from %s to %s", Cell.C1, Cell.G5)));
    }

}
