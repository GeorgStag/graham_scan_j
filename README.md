# graham_scan in java

Graham's scan is a method in Algebraic Topology, finding the convex hull of a finite set of points in the plane with time complexity O(nlogn).

Simply speaking, it is a really fast and simple algorithm to check if the shape of a set of 2D data could be of a circle with points in the interior.

Implementation, checking the statement above for a 2D dataset:

```java
public static void main(String[] args) {
	double[][] data = { 
	// points: x-y coordinates
		{1, 1},
		{2, 2},
		{3, 3},
		{4, 4}
	};
	grahamScan scanClass = new grahamScan();
	scanClass.setSample(data);
	System.out.println(scanClass.checkHull());
}
```
