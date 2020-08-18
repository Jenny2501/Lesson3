package ru.geekbrains.j_one.lesson_a.online;



    import java.util.Random;
    import java.util.Scanner;

        class CitCatToy {

            private static final char DOT_EMPTY = ' ';
            private static final char DOT_HUMAN = 'X';
            private static final char DOT_AI = 'O';
            private static char[][] field;
            private static int fieldSizeX;
            private static int fieldSizeY;
            private static final Scanner SCANNER = new Scanner(System.in);
            private static final Random RANDOM = new Random();


            // inits field
            private static void initField() {
                fieldSizeX = 3;
                fieldSizeY = 3;
                field = new char[fieldSizeY][fieldSizeX];
                for (int y = 0; y < fieldSizeY; y++) {
                    for (int x = 0; x < fieldSizeX; x++) {
                        field[y][x] = DOT_EMPTY;
                    }
                }
            }

            // print field
            private static void printField() {
                System.out.print("*");
                for (int i = 0; i < fieldSizeX * 2 + 1; i++)
                    System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
                System.out.println();

                for (int i = 0; i < fieldSizeY; i++) {
                    System.out.print(i + 1 + "|");
                    for (int j = 0; j < fieldSizeX; j++)
                        System.out.print(field[i][j] + "|");
                    System.out.println();
                }

                for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
                    System.out.print("-");
                System.out.println();
            }

            // human turn
            private static void humanTurn() {
                int x;
                int y;
                do {
                    System.out.print("Введите координаты хода X и Y ");
                    x = SCANNER.nextInt() - 1;
                    y = SCANNER.nextInt() - 1;
                } while (!isValidCell(x, y) || !isCellEmpty(x, y));
                field[y][x] = DOT_HUMAN;
            }

            // check valid cell
            private static boolean isValidCell(int x, int y) {
                return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
            }

            // check empty cell
            private static boolean isCellEmpty(int x, int y) {
                return field[y][x] == DOT_EMPTY;
            }

            // ai turn
            private static void aiTurn() {
                int x;
                int y;
                do {
                    x = RANDOM.nextInt(fieldSizeX);
                    y = RANDOM.nextInt(fieldSizeY);
                } while (!isCellEmpty(x, y));
                field[y][x] = DOT_AI;
            }

            // check draw
            private static boolean checkDraw() {
                for (int y = 0; y < fieldSizeY; y++) {
                    for (int x = 0; x < fieldSizeX; x++) {
                        if (field[y][x] == DOT_EMPTY)
                            return false;
                    }
                }
                return true;
            }


            // check win
            private boolean checkWinner() {
                return checkWinnerHorizontal() ||
                        checkWinnerVertical() ||
                        checkWinnerDiagonals();
            }

            private boolean checkWinnerHorizontal() {

                for (int x = 0; x < fieldSizeX; x++) {
                    boolean res = true;
                    for (int y = 1; y < fieldSizeY && res; y++)
                        res = field[x][y] == field[x][0];
                    if (res)
                        return true;
                }
                return false;
            }

            private boolean checkWinnerVertical() {
                for (int x = 0; x < fieldSizeX; x++) {
                    boolean res = true;
                    for (int y = 1; y < fieldSizeY && res; y++)
                        res = field[y][x] == field[0][x];
                    if (res)
                        return true;
                }
                return false;
            }

            private boolean checkWinnerDiagonals() {
                boolean res = true;
                for (int x = 1; x < fieldSizeX && res; x++)
                    res = field[x][x] == field[0][0];
                if (res)
                    return true;
                res = true;
                for (int x = 1; x < fieldSizeX && res; x++)
                    res = field[fieldSizeX - x - 1][x] == field[fieldSizeX - 1][0];
                return res;
            }

            public static void main(String[] args) {
                initField();
                printField();
                while (true) {
                    humanTurn();
                    printField();
                    if (gameChecks(DOT_HUMAN, "Human Win!"))
                        break;
                    aiTurn();
                    printField();
                    if (gameChecks(DOT_AI, "Computer win!"))
                        break;
                }
            }

            private static boolean gameChecks(char dot, String msg) {
                if (checkWin(dot)) {
                    System.out.println(msg);
                    return true;
                }
                if (checkDraw()) {
                    System.out.println("Draw");
                    return true;
                }
                return false;
            }

            private static boolean checkWin(char dot)
            {if (checkWin(dot)) {
                boolean msg = false;
                System.out.println(false);
                return true;
            }
                if (checkDraw()) {
                    System.out.println("Draw");
                    return true;
                }
                return false;
                // inits field
                private static void initField()
            {
                fieldSizeX = 5;
                fieldSizeY = 5;
                field = new char[fieldSizeY][fieldSizeX];
                for (int y = 0; y < fieldSizeY; y++) {
                    for (int x = 0; x < fieldSizeX; x++) {
                        field[y][x] = DOT_EMPTY;
                    }
                }
            }
                // print field
                private static void printField() {
                System.out.print("*");
                for (int i = 0; i < fieldSizeX * 2 + 3; i++)
                    System.out.print((i % 2 == 0) ? "-" : i / 2 + 3);
                System.out.println();

                for (int i = 0; i < fieldSizeY; i++) {
                    System.out.print(i + 1 + "|");
                    for (int j = 0; j < fieldSizeX; j++)
                        System.out.print(field[i][j] + "|");
                    System.out.println();
                }

                for (int i = 0; i <= fieldSizeX * 2 + 3; i++)
                    System.out.print("-");
                System.out.println();
            }
                boolean checkWin(char dot) {
                int diag1, diag2, hor, ver;
                for (int i = 0; i < fieldSizeX; i++) {
                    hor = 0; ver = 0;
                    for (int j = 0; j < fieldSizeX; j++) {
                        if (map[i][j] == dot) {
                            hor++;
                        }
                        if (map[j][i] == dot) {
                            ver++;
                        }
                    }
                    if (hor == fieldSizeX|| ver == fieldSizeX) {
                        return true;
                    }
                }
                diag1 = 0; diag2 = 0;
                for (int i = 0; i < fieldSizeX; i++) {
                    if (map[i][i] == dot) {
                        diag1++;
                    }
                    if (map[i][fieldSizeX - i - 1] == dot) {
                        diag2++;
                    }
                }
                if (diag1 == fieldSizeX || diag2 == fieldSizeX) {
                    return true;
                }
                return false;
            }

            }


        }


