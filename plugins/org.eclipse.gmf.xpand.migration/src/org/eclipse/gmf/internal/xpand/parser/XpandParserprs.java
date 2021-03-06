/*******************************************************************************
* Copyright (c) 2006, 2007 Eclipse.org
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
package org.eclipse.gmf.internal.xpand.parser;

public class XpandParserprs implements lpg.lpgjavaruntime.ParseTable, XpandParsersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static short baseCheck[] = {0,
            1,6,1,4,1,1,3,1,5,10,
            1,0,5,1,3,1,3,1,3,1,
            3,1,1,1,1,1,1,1,3,1,
            1,1,3,1,1,1,2,2,2,3,
            1,2,1,1,1,1,1,1,1,1,
            3,4,3,1,1,3,2,2,1,1,
            1,1,1,4,6,4,1,1,1,1,
            1,1,0,1,2,4,1,3,1,1,
            4,1,1,1,3,1,1,3,1,0,
            3,5,4,4,0,1,0,1,0,2,
            0,2,4,0,2,4,6,9,11,9,
            2,2,0,1,2,6,9,2,0,3,
            1,1,1,1,1,1,3,0,3,0,
            1,1,1,1,2,3,5,6,0,3,
            1,1,5,0,1,8,0,2,0,2,
            6,0,4,0,2,6,10,0,1,-52,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-105,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-161,0,0,0,
            -92,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            -106,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-72,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-13,0,0,-17,0,-101,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-50,0,0,0,
            0,-129,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-71,0,0,-3,0,-135,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-2,0,-29,0,
            0,-67,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-81,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-82,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-83,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-84,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-85,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-96,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-99,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-109,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-117,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-145,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-148,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-149,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-154,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-156,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-171,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-174,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-133,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-160,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,-110,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,-93,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-144,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,-94,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,-170,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,-179,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,-180,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            -108,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,-95,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,-107,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,-65,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,-66,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,-124,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,-104,0,0,0,0,
            0,0,0,0,-33,0,0,0,0,0,
            -36,0,0,0,0,0,-59,0,0,0,
            0,0,-34,0,0,0,0,0,-37,0,
            0,0,0,0,-56,0,0,0,0,0,
            0,-31,-30,0,-32,-4,0,-11,-80,0,
            0,-1,0,-58,0,0,0,0,0,-88,
            0,0,0,0,0,-100,0,0,0,0,
            0,-121,0,0,0,0,0,-43,0,0,
            0,0,0,0,0,0,0,0,-45,0,
            0,-89,0,-113,-91,-8,-112,-115,-74,-9,
            -119,-14,-15,-136,-16,-6,-143,0,0,0,
            -155,-7,-12,-165,0,0,-166,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,-172,
            0,0,0,0,0,0,0,0,0,-181,
            0,-25,-26,0,-35,0,-75,0,0,-153,
            0,-73,0,0,0,-61,-5,-87,-10,0,
            0,0,-141,-21,-22,-23,-28,-131,-130,0,
            0,0,-138,-152,-159,-162,0,0,-173,0,
            -178,0,0,-183,0,0,0,0,0,0,
            -18,0,0,-19,0,-20,0,0,0,0,
            -24,-27,-38,-39,-40,-41,-42,-44,-46,0,
            0,0,-47,-48,0,0,-49,-51,-53,0,
            0,-54,-55,-57,0,-60,-62,-63,-64,-68,
            -69,-70,-76,-77,0,-78,0,-79,-86,-90,
            0,-97,-98,0,-102,-103,-111,-114,-116,-118,
            -120,-122,0,-123,-125,-126,-127,-128,-132,-134,
            -137,-139,-140,-142,-146,-147,-150,-151,-157,-158,
            -163,-164,-167,-168,-169,-175,-176,-177,-182,-184,
            0
        };
    };
    public final static short baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static short rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            63,28,29,29,27,27,25,25,26,26,
            24,24,41,41,23,23,21,21,22,22,
            20,20,64,64,64,64,64,64,19,19,
            42,42,17,17,65,65,18,18,18,43,
            43,9,9,10,10,10,10,10,10,10,
            10,10,6,6,6,6,15,15,16,11,
            11,14,12,13,7,7,7,8,8,8,
            8,8,8,74,74,36,36,34,34,3,
            3,4,5,5,5,2,2,1,1,63,
            66,66,63,37,37,46,46,75,75,33,
            33,44,44,47,45,45,48,39,39,39,
            39,35,35,40,40,40,38,38,32,49,
            49,50,50,50,50,50,50,31,57,57,
            30,30,51,51,51,58,59,59,59,68,
            68,67,60,52,69,69,53,70,70,61,
            61,54,62,62,71,71,55,56,72,72,
            1,86,80,54,79,1497,50,55,1520,36,
            1442,44,45,46,47,48,49,28,1379,1437,
            1519,1518,1523,11,1517,5,1526,3,142,1,
            213,86,80,54,79,1497,50,55,1520,36,
            1442,44,45,46,47,48,49,33,1379,118,
            1446,121,122,123,124,125,126,501,132,133,
            134,1,86,80,54,79,1497,50,55,1520,
            36,1442,44,45,46,47,48,49,28,1379,
            1437,1519,1518,1523,11,1517,5,1526,3,142,
            1,213,86,80,54,79,1497,50,55,1520,
            36,1442,44,45,46,47,48,49,29,1379,
            120,1446,121,122,123,124,125,126,138,132,
            133,134,34,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1536,1,71,86,1484,29,1535,77,86,80,
            54,79,1497,50,55,1520,36,1442,44,45,
            46,47,48,49,28,1379,1437,1519,1518,1523,
            11,1517,5,1526,3,1536,1,71,86,1516,
            1491,1548,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1536,1,71,86,58,8,78,105,86,80,
            54,79,1497,50,55,1520,36,1442,44,45,
            46,47,48,49,28,1379,1437,1519,1518,1523,
            11,1517,5,1526,3,1536,1,62,1326,396,
            88,1557,105,86,80,1533,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1532,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            135,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1374,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1538,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1378,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1539,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1532,1,133,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1545,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1549,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1553,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1560,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            217,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            137,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1397,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1564,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            150,1,105,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,3,
            1471,1,187,86,80,54,79,1497,50,55,
            1520,36,1442,44,45,46,47,48,49,28,
            1379,1437,1519,1518,1523,11,1517,5,1526,1556,
            187,86,80,54,79,1497,50,55,1520,36,
            1442,44,45,46,47,48,49,28,1379,1437,
            1519,1518,1523,11,1517,5,1526,2,161,86,
            80,54,79,1497,50,55,1520,36,1442,44,
            45,46,47,48,49,28,1379,1437,1519,1518,
            1523,11,1517,7,1526,161,86,80,54,79,
            1497,50,55,1520,36,1442,44,45,46,47,
            48,49,28,1379,1437,1519,1518,1523,11,1544,
            161,86,80,54,79,1497,50,55,1520,36,
            1442,44,45,46,47,48,49,28,1379,1437,
            1519,1518,1523,11,9,213,86,80,54,79,
            1497,50,55,1520,36,1442,44,45,46,47,
            48,49,28,1379,1437,1519,1518,1523,15,213,
            86,80,54,79,1497,50,55,1520,36,1442,
            44,45,46,47,48,49,28,1379,1437,1519,
            1518,1523,1567,213,86,80,54,79,1497,50,
            55,1520,36,1442,44,45,46,47,48,49,
            28,1379,1437,1519,1518,1523,1569,213,86,80,
            54,79,1497,50,55,1520,36,1442,44,45,
            46,47,48,49,28,1379,1437,1519,1518,1523,
            1474,213,86,80,54,79,1497,50,55,1520,
            36,1442,44,45,46,47,48,49,28,1379,
            1437,1519,17,1523,213,86,80,54,79,1497,
            50,55,1520,36,1442,44,45,46,47,48,
            49,28,1379,1437,19,213,86,80,54,79,
            1497,50,55,1520,36,1442,44,45,46,47,
            48,49,28,1379,1458,285,86,80,54,79,
            1497,50,55,1520,38,1442,44,45,46,47,
            48,49,285,86,80,54,79,1497,50,55,
            1520,37,1442,44,45,46,47,48,49,285,
            86,80,54,79,1497,50,55,1520,4,1442,
            44,45,46,47,48,49,309,86,80,54,
            79,1497,1459,55,1520,326,86,80,1496,79,
            1497,332,86,80,1496,79,1497,332,86,80,
            1496,79,1497,332,86,80,1358,79,1497,332,
            86,80,1369,79,1497,332,86,80,1372,79,
            1497,1495,340,396,85,340,69,1498,338,71,
            86,141,31,76,332,86,80,1375,79,1497,
            332,86,80,1381,79,1497,332,86,80,1547,
            79,1497,332,86,80,1387,79,1497,27,96,
            1385,1383,96,1385,1383,92,1385,1383,94,27,
            1386,93,27,1392,454,27,131,449,27,356,
            389,27,268,291,27,371,318,27,1509,160,
            1508,27,69,318,27,417,1377,27,89,1509,
            160,1513,1509,160,1541,1509,160,1542,1509,160,
            1463,1509,160,1554,1509,160,1558,1509,160,1559,
            27,1509,160,1563,1509,160,155,1509,160,1469,
            27,1328,353,353,1393,353,102,311,105,1392,
            496,1393,293,1384,190,1550,27,220,386,220,
            1509,160,1568,388,220,220,220,220,67,469,
            1509,160,1570,475,494,502,501,114,114,475,
            114,515,112,111,502,115,1509,221,1540,251,
            1380,390,100,1540,393,42,334,103,1322,1325,
            106,357,358,157,339,373,402,399,404,168,
            251,1205,40,405,407,127,1565,408,409,413,
            129,1562,416,415,418,13,419,420,25,421,
            422,426,370,423,427,1440,431,1420,435,432,
            438,153,439,443,1466,444,447,448,452,456,
            457,458,459,1430,462,460,341,461,470,471,
            361,473,482,484,485,486,487,493,488,497,
            498,506,509,510,511,512,513,514,516,518,
            519,1573,1573
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,0,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,0,25,0,27,0,1,
            0,24,6,0,1,2,3,4,5,6,
            40,8,9,10,11,12,13,14,15,16,
            17,18,19,20,21,22,23,29,25,0,
            27,0,62,63,0,32,0,67,0,69,
            0,1,6,73,50,75,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            34,25,41,27,0,1,2,3,4,5,
            6,81,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,60,25,
            0,27,0,1,2,3,4,5,6,9,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,0,25,0,27,
            0,1,2,3,4,5,6,0,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,28,25,0,1,2,3,
            4,5,6,26,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            0,25,0,1,2,3,4,5,6,0,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,0,1,2,3,
            4,5,6,24,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            0,1,2,3,4,5,6,0,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,0,1,2,3,4,5,
            0,24,0,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,0,1,
            0,3,4,5,24,0,6,0,10,11,
            12,13,14,15,16,0,1,35,3,4,
            5,0,1,0,3,4,5,0,0,0,
            0,8,2,0,34,7,0,1,8,3,
            4,5,0,1,29,0,0,0,2,2,
            0,28,52,53,54,55,56,57,28,0,
            0,2,0,36,37,36,37,8,61,7,
            28,29,26,26,29,0,26,0,0,0,
            1,6,0,6,24,0,1,28,0,59,
            40,0,1,0,0,33,0,0,0,24,
            7,24,0,58,0,0,24,0,0,0,
            0,0,0,2,7,0,0,2,2,41,
            0,0,26,29,0,1,24,0,0,31,
            33,26,0,0,46,7,0,0,0,7,
            2,0,38,0,1,0,0,0,0,0,
            0,0,42,26,45,47,7,7,0,0,
            0,49,0,1,0,32,7,7,48,33,
            24,0,1,0,0,0,0,0,31,31,
            39,30,0,0,39,0,0,0,51,7,
            0,0,17,35,7,0,1,76,0,0,
            0,0,0,0,0,0,30,0,0,0,
            0,0,38,0,0,0,0,31,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,30,30,70,44,0,24,0,32,
            0,0,0,0,43,68,0,0,65,0,
            77,0,0,0,64,0,71,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            72,66,0,74,0,0,0,0,78,0,
            0,0,0,79,0,0,0,0,80,0,
            0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            119,1522,422,1655,1656,1657,1225,99,1242,1616,
            1521,1640,1641,1642,1643,1644,1645,282,1635,1636,
            382,1632,1633,1634,14,1524,130,1528,1573,1432,
            90,1447,1704,1573,1522,422,1655,1656,1657,1225,
            512,1242,1616,1521,1640,1641,1642,1643,1644,1645,
            282,1635,1636,382,1632,1633,1634,1433,1524,1573,
            1528,1573,452,1329,1573,1630,21,482,101,542,
            1573,1486,1993,572,1065,1529,1573,1522,422,1655,
            1656,1657,1225,1626,1242,1616,1521,1640,1641,1642,
            1643,1644,1645,282,1635,1636,382,1632,1633,1634,
            1603,1524,1572,1528,1573,1522,422,1655,1656,1657,
            1225,385,1242,1616,1521,1640,1641,1642,1643,1644,
            1645,282,1635,1636,382,1632,1633,1634,1376,1524,
            1573,1528,1573,1546,422,1655,1656,1657,1225,1382,
            1242,1616,1521,1640,1641,1642,1643,1644,1645,282,
            1635,1636,382,1632,1633,1634,87,1524,1573,1528,
            1573,1522,602,1655,1656,1657,1225,1573,1242,1616,
            1521,1640,1641,1642,1643,1644,1645,282,1635,1636,
            382,1632,1633,1634,419,1524,1573,1522,422,1655,
            1656,1657,1225,1315,1242,1616,1521,1640,1641,1642,
            1643,1644,1645,282,1635,1636,382,1632,1633,1634,
            1573,1524,1573,1522,602,1655,1656,1657,1225,99,
            1242,1616,1521,1640,1641,1642,1643,1644,1645,282,
            1635,1636,382,1632,1633,1634,20,1604,1604,1604,
            1604,1604,1604,1449,1604,1604,1604,1604,1604,1604,
            1604,1604,1604,1604,1604,1604,1604,1604,1604,1604,
            21,1604,1604,1604,1604,1604,1604,1573,1604,1604,
            1604,1604,1604,1604,1604,1604,1604,1604,1604,1604,
            1604,1604,1604,1604,1573,1522,602,1655,1656,1657,
            1573,1454,41,1616,1521,1640,1641,1642,1643,1644,
            1645,282,1635,1636,382,1632,1633,1634,1573,1522,
            20,1655,1656,1657,1455,1573,1969,104,1521,1640,
            1641,1642,1643,1644,1645,1573,1486,1276,1655,1656,
            1657,1573,1486,87,1655,1656,1657,1573,1573,95,
            87,1323,317,1573,1603,1499,75,1297,1323,1297,
            1297,1297,113,1432,1494,32,1573,1573,1285,1291,
            136,419,1595,1596,1597,1598,1599,1600,419,87,
            1573,317,1573,315,1481,315,1481,1323,312,1504,
            1435,1433,1303,1309,1607,128,782,128,100,1573,
            1492,2256,1573,2256,1456,1573,1493,419,1573,722,
            752,1573,1507,1573,1573,1503,1573,75,1573,130,
            1512,130,1573,1608,1573,1573,1457,1573,1573,8,
            18,1573,16,632,1530,1573,1573,1346,662,91,
            6,1573,1334,1514,1573,1537,1448,1573,1573,1680,
            2079,1340,54,1573,347,1624,77,1573,139,1259,
            387,1573,1689,144,1718,1573,1573,1573,1573,1573,
            1573,1573,1184,1352,1015,1654,1639,1637,39,1573,
            1573,1161,1573,1464,152,1629,1625,1555,988,352,
            1453,1573,1391,1573,1573,1573,1573,1573,1683,1681,
            1551,1040,1573,147,1552,154,1573,1573,932,1713,
            149,12,1465,1276,1638,1573,1721,692,1573,1573,
            1573,1573,1573,1573,158,1573,960,1573,1573,1573,
            1573,1573,1690,128,1573,1573,1573,1682,1573,1573,
            1573,1573,1573,1573,1573,1573,1573,1573,1573,1573,
            1573,1573,1113,1137,812,1089,1573,1704,1573,1583,
            1573,1573,1573,1573,1566,1716,1573,1573,1561,1573,
            842,1573,1573,1573,872,1573,1394,1573,1573,1573,
            1573,1573,1573,1573,1573,1573,1573,1573,1573,1573,
            1724,1719,1573,1729,1573,1573,1573,1573,902,1573,
            1573,1573,1573,1732,1573,1573,1573,1573,1730
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static char asb[] = {0,
            65,138,53,88,86,89,88,72,87,86,
            90,89,133,186,186,186,62,133,186,152,
            53,135,135,83,80,80,83,54,133,133,
            136,136,59,130,80,130,130,153,233,232,
            133,188,185,233,185,78,227,78,232,133,
            190,94,186,78,192,130,233,130,130,194,
            185,173,170,168,114,114,110,261,261,196,
            133,1,158,159,161,169,261,174,133,133,
            110,110,110,110,110,229,93,130,185,78,
            185,94,111,112,112,110,233,211,110,130,
            27,25,231,123,112,112,112,112,110,111,
            235,74,68,237,185,237,110,186,185,190,
            130,190,239,114,233,241,233,233,110,158,
            167,233,111,75,110,185,133,140,133,263,
            93,192,185,111,110,51,239,110,110,233,
            265,144,141,110,185,110,190,233,149,111,
            145,145,133,142,185,185,267,269,150,112,
            110,185,140,110,239,239,271,184,112,112,
            185,25,149,273
        };
    };
    public final static char asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            2,8,6,9,1,3,4,5,10,11,
            12,13,14,15,16,20,17,23,19,18,
            21,22,25,27,32,0,2,8,6,9,
            1,3,4,5,10,11,12,13,14,15,
            16,20,23,19,18,21,22,25,27,7,
            17,0,60,61,36,37,24,0,3,4,
            5,29,1,0,41,81,0,6,24,1,
            0,9,0,2,6,24,40,26,0,29,
            1,28,26,2,0,24,41,60,61,37,
            36,0,24,31,38,66,68,70,71,72,
            74,80,75,73,69,40,67,62,63,27,
            25,8,6,9,2,20,17,23,19,18,
            21,22,10,11,12,13,14,15,16,3,
            4,5,1,0,24,37,36,41,0,70,
            71,72,0,65,6,24,64,0,44,43,
            0,8,2,47,26,40,28,35,29,58,
            52,53,54,55,56,57,34,42,49,43,
            44,50,45,1,30,7,32,33,64,39,
            77,78,48,79,6,24,0,46,0,31,
            0,38,0,47,0,1,43,44,30,32,
            33,64,39,77,78,79,24,2,8,28,
            42,45,48,49,50,52,53,54,55,56,
            57,34,6,58,35,7,29,0,76,0,
            32,33,7,0,51,0,39,0,30,0,
            42,45,7,48,49,50,52,53,54,55,
            56,57,34,6,29,58,35,59,8,28,
            2,0,77,0,68,0,74,0,78,0,
            66,0,80,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            40,5,12,32,12,51,32,5,5,12,
            34,51,8,5,5,5,10,5,5,5,
            12,12,12,5,53,53,5,12,14,14,
            28,28,24,17,53,24,17,5,5,5,
            5,5,42,5,42,5,5,5,5,8,
            5,1,5,5,5,17,5,17,24,5,
            42,5,5,5,2,2,16,5,5,5,
            8,2,60,49,55,5,5,5,5,38,
            2,2,2,2,2,5,62,17,42,5,
            42,1,2,2,2,2,5,5,2,17,
            2,5,5,20,2,2,2,2,2,2,
            5,47,45,5,42,5,2,5,42,5,
            17,5,5,2,5,5,5,5,2,60,
            56,5,2,5,2,42,5,65,5,5,
            62,5,42,2,2,5,5,2,2,5,
            5,67,58,2,42,2,5,5,69,2,
            6,6,5,5,42,42,5,5,5,2,
            2,42,65,2,5,5,5,71,2,2,
            42,5,69,5
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static char nasr[] = {0,
            49,5,8,10,0,61,0,2,0,35,
            0,33,0,1,0,8,5,3,0,5,
            8,6,0,5,3,36,0,38,39,46,
            0,47,0,38,39,37,0,67,0,63,
            0,30,31,0,69,0,68,0,65,0,
            48,0,40,0,64,42,0,71,0,43,
            0,30,57,0,62,0,70,0,41,0,
            72,0
        };
    };
    public final static char nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static byte terminalIndex[] = {0,
            30,4,43,44,45,22,5,11,31,46,
            47,48,49,50,51,52,6,32,33,37,
            38,39,40,82,35,61,34,2,23,3,
            56,7,26,21,25,55,57,58,63,65,
            81,36,41,42,1,8,9,10,12,13,
            14,15,16,17,18,19,20,24,27,53,
            54,59,60,62,64,66,67,68,69,70,
            71,72,73,74,75,76,77,78,79,80,
            28,83
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            109,105,86,0,108,102,0,106,87,103,
            0,0,0,0,0,0,97,99,95,94,
            92,93,91,90,88,89,85,84,0,0,
            117,116,0,104,115,107,110,111,112,0,
            0,98,101,0,0,0,113,114,0,118,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,96,100,0,119,0,0,0,
            0,0,0,0,0
        };
    };
    public final static byte nonterminalIndex[] = NonterminalIndex.nonterminalIndex;
    public final int nonterminalIndex(int index) { return nonterminalIndex[index]; }

    public interface ScopePrefix {
        public final static char scopePrefix[] = {
            1,87,29,97,13,21,57,39,128,51,
            68,121,109,63,72,75,80,46
        };
    };
    public final static char scopePrefix[] = ScopePrefix.scopePrefix;
    public final int scopePrefix(int index) { return scopePrefix[index]; }

    public interface ScopeSuffix {
        public final static char scopeSuffix[] = {
            11,66,37,104,19,27,55,44,133,55,
            55,125,113,66,55,78,83,48
        };
    };
    public final static char scopeSuffix[] = ScopeSuffix.scopeSuffix;
    public final int scopeSuffix(int index) { return scopeSuffix[index]; }

    public interface ScopeLhs {
        public final static char scopeLhs[] = {
            56,24,53,24,55,54,7,52,29,7,
            6,26,24,15,10,43,41,49
        };
    };
    public final static char scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static byte scopeLa[] = {
            80,32,66,43,74,72,7,68,30,7,
            7,30,7,32,7,35,30,6
        };
    };
    public final static byte scopeLa[] = ScopeLa.scopeLa;
    public final int scopeLa(int index) { return scopeLa[index]; }

    public interface ScopeStateSet {
        public final static byte scopeStateSet[] = {
            46,20,46,20,46,46,7,46,25,7,
            7,22,20,8,8,4,1,46
        };
    };
    public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;
    public final int scopeStateSet(int index) { return scopeStateSet[index]; }

    public interface ScopeRhs {
        public final static char scopeRhs[] = {0,
            114,154,110,78,110,77,110,76,75,0,
            80,0,114,1,39,110,73,0,74,0,
            153,144,114,110,69,0,72,0,114,143,
            152,1,39,110,40,0,66,0,114,151,
            110,67,0,68,0,132,0,117,0,0,
            110,2,90,0,5,0,110,59,1,2,
            90,0,116,17,0,7,0,116,2,1,
            0,110,2,0,88,35,0,101,0,105,
            44,0,3,91,0,0,105,30,43,123,
            17,7,110,2,25,0,123,17,7,110,
            2,25,0,41,3,91,7,0,110,2,
            25,0,5,6,0,41,3,91,7,0,
            106,45,106,0,3,90,0,109,51,1,
            27,0,3,85,0
        };
    };
    public final static char scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static char scopeState[] = {0,
            1474,1465,0,1459,1442,0,1276,1137,1113,1089,
            1259,1161,1205,251,190,1184,1065,1242,1225,1040,
            1015,960,932,988,902,872,842,812,782,752,
            722,387,352,692,662,317,632,602,572,542,
            512,482,452,282,422,221,160,0
        };
    };
    public final static char scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static char inSymb[] = {0,
            0,145,81,115,24,126,129,60,115,24,
            127,130,61,9,121,120,36,37,84,1,
            24,24,24,117,1,29,1,24,28,8,
            115,115,2,26,28,2,26,1,29,118,
            85,87,85,118,85,7,33,7,1,46,
            114,113,112,7,114,26,29,26,33,84,
            132,106,103,102,6,8,2,90,10,1,
            20,17,92,100,101,104,25,108,27,63,
            62,67,40,69,73,75,24,26,85,7,
            85,113,45,50,42,2,110,85,2,2,
            2,116,110,35,147,124,146,49,2,48,
            1,149,110,110,110,110,76,112,85,114,
            26,114,106,7,110,1,85,116,33,88,
            101,110,51,150,2,151,39,114,39,110,
            24,114,85,30,59,7,109,40,26,116,
            114,1,144,70,1,77,114,110,17,30,
            110,152,65,153,71,110,114,110,123,44,
            64,143,114,78,43,105,114,110,30,30,
            154,105,105,114
        };
    };
    public final static char inSymb[] = InSymb.inSymb;
    public final int inSymb(int index) { return inSymb[index]; }

    public interface Name {
        public final static String name[] = {
            "",
            "?",
            "::",
            ":",
            "(",
            ")",
            "{",
            "}",
            "[",
            "]",
            "->",
            "!",
            "&&",
            "||",
            "=",
            "==",
            "!=",
            ">=",
            "<=",
            ">",
            "<",
            "+",
            "-",
            "*",
            "/",
            ".",
            ",",
            "|",
            "\\u00AB",
            "$empty",
            "IDENT",
            "STRING",
            "INT_CONST",
            "REAL_CONST",
            "let",
            "switch",
            "implies",
            "new",
            "false",
            "true",
            "null",
            "default",
            "case",
            "Collection",
            "List",
            "Set",
            "typeSelect",
            "collect",
            "select",
            "reject",
            "exists",
            "notExists",
            "forAll",
            "IMPORT",
            "EXTENSION",
            "AROUND",
            "ENDAROUND",
            "DEFINE",
            "ENDDEFINE",
            "ERROR",
            "EXPAND",
            "FOR",
            "SEPARATOR",
            "AS",
            "ITERATOR",
            "FOREACH",
            "ENDFOREACH",
            "FILE",
            "ENDFILE",
            "IF",
            "ELSEIF",
            "ELSE",
            "ENDIF",
            "LET",
            "ENDLET",
            "PROTECT",
            "CSTART",
            "CEND",
            "ID",
            "DISABLE",
            "ENDPROTECT",
            "EOF_TOKEN",
            "TEXT",
            "ERROR_TOKEN",
            "expression",
            "castedExpression",
            "type",
            "infixExpression",
            "chainExpression",
            "ifExpression",
            "switchExpression",
            "orExpression",
            "andExpression",
            "impliesExpression",
            "relationalExpression",
            "additiveExpression",
            "relationalOperator",
            "multiplicativeExpression",
            "additiveOperator",
            "unaryExpression",
            "multiplicativeOperator",
            "infixExpressionSuffix",
            "featureCall",
            "primaryExpression",
            "parameterList",
            "simpleType",
            "collectionExpressionName",
            "declaredParameterList",
            "collectionTypeName",
            "qualifiedType",
            "defineOrAroundSeq",
            "define",
            "around",
            "anImport",
            "anExtensionImport",
            "pointcut",
            "sequence",
            "text",
            "statement",
            "definitionName"
        };
    };
    public final static String name[] = Name.name;
    public final String name(int index) { return name[index]; }

    public final static int
           ERROR_SYMBOL      = 82,
           SCOPE_UBOUND      = 17,
           SCOPE_SIZE        = 18,
           MAX_NAME_LENGTH   = 24;

    public final int getErrorSymbol() { return ERROR_SYMBOL; }
    public final int getScopeUbound() { return SCOPE_UBOUND; }
    public final int getScopeSize() { return SCOPE_SIZE; }
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int
           NUM_STATES        = 184,
           NT_OFFSET         = 82,
           LA_STATE_OFFSET   = 1732,
           MAX_LA            = 2,
           NUM_RULES         = 159,
           NUM_NONTERMINALS  = 75,
           NUM_SYMBOLS       = 157,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 1332,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 41,
           EOLT_SYMBOL       = 41,
           ACCEPT_ACTION     = 1572,
           ERROR_ACTION      = 1573;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) {
        return -baseCheck[state];
    }
    public final int asi(int state) {
        return asb[originalState(state)];
    }
    public final int nasi(int state) {
        return nasb[originalState(state)];
    }
    public final int inSymbol(int state) {
        return inSymb[originalState(state)];
    }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
