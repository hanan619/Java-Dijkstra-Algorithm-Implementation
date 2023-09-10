import java.util.*;

public class Main {

	static List<List<Vertex>> listOfRect = new ArrayList<>();
	static public void init()
	{
		Vertex[] rectUxangle = {new Vertex(8,8), new Vertex(8,12), new Vertex(11,12), new Vertex(11,8)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[] {new Vertex(5,6), new Vertex(5,12), new Vertex(7,12), new Vertex(7,6)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(18,8), new Vertex(18,11), new Vertex(20,11), new Vertex(20,8)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(13,12), new Vertex(13,17), new Vertex(22,17), new Vertex(22,12)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(5,19), new Vertex(5,20), new Vertex(10,20), new Vertex(10,19)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(18,14), new Vertex(18,23), new Vertex(20,23), new Vertex(20,14)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(10,14), new Vertex(10,19), new Vertex(15,19), new Vertex(15,14)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(7,17), new Vertex(7,18), new Vertex(14,18), new Vertex(14,17)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(7,22), new Vertex(7,23), new Vertex(8,23), new Vertex(8,22)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(5,15), new Vertex(5,18), new Vertex(6,18), new Vertex(6,15)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(12,7), new Vertex(12,10), new Vertex(16,10), new Vertex(16,7)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(11,18), new Vertex(11,23), new Vertex(14,23), new Vertex(14,18)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(13,10), new Vertex(13,16), new Vertex(19,16), new Vertex(19,10)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(9,5), new Vertex(9,9), new Vertex(13,9), new Vertex(13,5)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(15,5), new Vertex(15,9), new Vertex(16,9), new Vertex(16,5)};
		listOfRect.add(Arrays.asList(rectUxangle));
		rectUxangle = new Vertex[]  {new Vertex(0,17), new Vertex(0,19), new Vertex(6,19), new Vertex(6,17)};
		listOfRect.add(Arrays.asList(rectUxangle));

	}

	static public List<Vertex> nextConfig(Vertex v, int vertexIndex)
	{
		List<Vertex> retVal = new ArrayList<Vertex>();
		boolean flag = true;
		for(List<Vertex> rectVx: listOfRect)
		{
			for(int j = 0; j < 4; ++j)
			{
				Vertex vx = rectVx.get(j);
				flag = true;
				if(vx.equals(v))	// Skip comparison with itself
					continue;
				else if(rectVx.contains(v))	// Skip comparison with opposite vertex of same rectangle
				{
					int index = rectVx.indexOf(v);
					if(vx.equals(rectVx.get((index + 2) %4)))
						continue;
				}
				else if(vertexIndex == 0 && v.get_x() < vx.get_x() && v.get_y() < vx.get_y()) // skip v if it lies in 2nd quadrant of vx
				{
					continue;
				}
				else if(vertexIndex == 1 && v.get_x() < vx.get_x() && v.get_y() > vx.get_y()) // skip v if it lies in 1st quadrant of vx
				{
					continue;
				}
				else if(vertexIndex == 2 && v.get_x() > vx.get_x() && v.get_y() > vx.get_y()) // skip v if it lies in 3rd quadrant of vx)
				{
					continue;
				}
				else if(vertexIndex == 3 && v.get_x() > vx.get_x() && v.get_y() < vx.get_y()) // skip v if it lies in 4th quadrant of vx
				{
					continue;
				}
				else if(j == 0 && v.get_x() > vx.get_x() && v.get_y() > vx.get_y()) // skip v if it lies in 2nd quadrant of vx
				{
					continue;
				}
				else if(j == 1 && v.get_x() > vx.get_x() && v.get_y() < vx.get_y()) // skip v if it lies in 1st quadrant of vx
				{
					continue;
				}
				else if(j == 2 && v.get_x() < vx.get_x() && v.get_y() < vx.get_y()) // skip v if it lies in 3rd quadrant of vx)
				{
					continue;
				}
				else if(j == 3 && v.get_x() < vx.get_x() && v.get_y() > vx.get_y()) // skip v if it lies in 4th quadrant of vx
				{
					continue;
				}
				
				for(List<Vertex> rectUx: listOfRect)
				{
					if (v.get_x() > rectUx.get(0).get_x() && v.get_x() < rectUx.get(2).get_x() &&
							v.get_y() > rectUx.get(0).get_y() && v.get_y() < rectUx.get(2).get_y()) // return empty if vertex is inside the area of another rectangle
						return new ArrayList<Vertex>();

					for(int i  = 0; i < 4; ++ i)
					{
						if (vx.get_x() > rectUx.get(0).get_x() && vx.get_x() < rectUx.get(2).get_x() && 
								vx.get_y() > rectUx.get(0).get_y() && vx.get_y() < rectUx.get(2).get_y()) // Skip comparison with vertices which are inside other rectangles
						{
							flag = false;
							break;
						}

						Vertex u1 = rectUx.get((i + 4)%4);
						Vertex u2 = rectUx.get((i + 5)%4);								
						if(Vertex.linesIntersect(v, vx, u1, u2)) // Compare with edges of rectangle 
						{
							flag = false;
							break;
						}
					}
					if(!flag)
						break;
				}
				if(flag)
				{
					retVal.add(vx);
				}
			}	
		}
		return retVal;

	}
	
	public static int vertexIndex(Vertex x)
	{
		int vertexIndex = 0; 
        for(List<Vertex> vl : Main.listOfRect)
        {
        	if(vl.contains(x))
        	{
        		vertexIndex = vl.indexOf(x);
        		break;
        	}
        }
        return vertexIndex;
	}

	public static void main(String args[])
	{
		init();
		System.out.println(nextConfig(new Vertex(10,20), 2));
		Dijkstra dijkstra = new Dijkstra();
        dijkstra.computePath(listOfRect.get(8).get(2));

        System.out.println(dijkstra.getShortestPathTo(listOfRect.get(10).get(1)));
        
	}

}
