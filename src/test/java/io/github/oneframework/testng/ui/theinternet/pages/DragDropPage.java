

package io.github.oneframework.testng.ui.theinternet.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

import io.github.oneframework.builders.Locator;
import lombok.Getter;

/**
 * Drag drop page.
 *
 * @author Rahul Rana
 * @since 26-Jul-2022
 */
@Getter
public class DragDropPage {
    private static final DragDropPage DRAG_DROP_PAGE = new DragDropPage ();

    /**
     * Drag and drop page instance.
     *
     * @return {@link DragDropPage}
     */
    public static DragDropPage dragDropPage () {
        return DRAG_DROP_PAGE;
    }

    private final Locator draggable = Locator.buildLocator ()
        .web (id ("draggable"))
        .name ("Draggable")
        .build ();
    private final Locator droppable = Locator.buildLocator ()
        .web (id ("droppable"))
        .name ("Droppable")
        .build ();
    private final Locator header    = Locator.buildLocator ()
        .web (tagName ("b"))
        .name ("Header")
        .parent (this.droppable)
        .build ();
}
