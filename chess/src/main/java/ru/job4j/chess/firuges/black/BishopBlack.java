package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        Cell pos = position();
        int size = dest.getX() - pos.getX();
        isDiagonal(pos, dest);
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            int deltaX = pos.getX() +1 + index ;
            int deltaY =pos.getY() +1 + index;
            steps[index] = Cell.findBy(deltaX,deltaY);
        }
        return steps;
    }


    public boolean isDiagonal(Cell source, Cell dest) throws ImpossibleMoveException {
        if ((dest.getX() - source.getX() != dest.getY() - source.getY())) {
            throw new ImpossibleMoveException(String.format
                    ("Could not way by diagonal from %s to %s", position, dest));
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
