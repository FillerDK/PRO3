# PRO3 – Advanced Programming

Java exercises from the course *Advanceret programmering* at Erhvervsakademi Aarhus (Datamatiker, spring 2025). Starter code and interfaces came from the course (folders named `udleveret` and `graphimplementationStuderende`). The implementations are mine.

## Contents

| Lecture | Topic | What is in the folder |
|---|---|---|
| L01 | Time complexity | Exercises on analyzing running time |
| L02 | Binary search trees | Traversals, height, min/max and leaf count, with a time complexity analysis in `opg3.java` |
| L03 | Dictionary on a binary search tree | A generic dictionary (get, put, remove, size) on an unbalanced binary search tree |
| L04 | Hashing | Hash set with chaining and with linear probing |
| L05 | Dictionaries with hashing | Double hashing with a DELETED marker and rehashing, plus a `HashMap`-based and a list-based dictionary |
| L06 | Graphs | Graph with adjacency lists (adjacency matrix and edge list variants are in the same folder) |
| L07 | Graph algorithms | Depth-first search (DFS), breadth-first search (BFS), connectivity, path finding, minimum spanning tree (Kruskal), shortest paths (Dijkstra) |
| L08 | Streams | Java streams exercises |
| L09 | Design patterns | Exercises on design patterns, including Singleton and Decorator |

## Notes

- The linear probing hash set marks deleted slots with a DELETED marker and rehashes when the load factor passes 0.75.

Each lecture has its own `src` folder.
