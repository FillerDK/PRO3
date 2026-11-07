# PRO3 – Advanced Programming

Java exercises from the course *Advanceret programmering* at Erhvervsakademi Aarhus (Datamatiker, spring 2025). Starter code and interfaces came from the course (folders named `udleveret` and `graphimplementationStuderende`). The implementations are mine.

## Contents

| Lecture | Topic | What is in the folder |
|---|---|---|
| L01 | Time complexity | Exercises on analyzing and minimizing running time, for example a prefix average computed in one pass |
| L02 | Binary search trees | Traversals, height, min/max and leaf count, with a time complexity analysis in `opg3.java` |
| L03 | Dictionary on a binary search tree | A generic dictionary (get, put, remove, size) built as a binary search tree |
| L04 | Hashing | Hash set with chaining and with linear probing |
| L05 | Hash-based dictionary | A dictionary with double hashing and rehashing, one built from an array of `HashMap` buckets, and a list-based dictionary |
| L06 | Graphs | Graph with adjacency lists (adjacency matrix and edge list variants are in the same folder) |
| L07 | Graph algorithms | Depth-first search (DFS), breadth-first search (BFS), connectivity, path finding, minimum spanning tree (Kruskal), shortest paths (Dijkstra) |
| L08 | Streams | Java streams on number lists, plus exercises on words and movies |
| L09 | Design patterns | Exercises including Singleton and Decorator |

## Notes

The linear probing hash set marks deleted slots with a DELETED marker and rehashes when the load factor passes 0.75.

Each lecture has its own `src` folder.
