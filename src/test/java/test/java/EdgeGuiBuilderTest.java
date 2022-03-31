package test.java;

import com.fernando.gui.graphics.NodeGui;
import com.fernando.gui.graphics.builder.EdgeGuiBuilder;
import com.fernando.gui.graphics.builder.NodeGuiBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EdgeGuiBuilderTest {
    private EdgeGuiBuilder builder;

    @Before
    public void Before() {
        builder = new EdgeGuiBuilder(100L);
    }

    @Test(expected = NullPointerException.class)
    public void WhenCreatingEdge_IfAnyNodeIsNull_ThenThrowError() {
        var start = new NodeGuiBuilder(0L)
                .getResult();
        NodeGui end = null;
        builder.buildShape(start, end);
        builder.getResult();
    }

    @Test
    public void AnEdgeShouldBeAddedOnNodes() {
        var nodeBuilder = new NodeGuiBuilder(0L);
        var start = nodeBuilder.getResult();
        nodeBuilder.setId(1L);
        var end = nodeBuilder.getResult();
        builder.buildShape(start, end);
        var edge = builder.getResult();
        Assert.assertTrue(start.getEdges().contains(edge));
        Assert.assertTrue(end.getEdges().contains(edge));
    }

    @Test
    public void AnEdgeShouldHaveExtremeNodesAsSet() {
        var nodeBuilder = new NodeGuiBuilder(0L);
        var start = nodeBuilder.getResult();
        nodeBuilder.setId(1L);
        var end = nodeBuilder.getResult();
        builder.buildShape(start, end);
        var edge = builder.getResult();
        Assert.assertEquals(start, edge.getStart());
        Assert.assertEquals(end, edge.getEnd());
    }
}
