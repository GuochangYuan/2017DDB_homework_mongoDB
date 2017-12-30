package common.ztree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ZtreeUtil {
	
	@SuppressWarnings("unchecked")
	public static List<TreeNode> nodesByConllectings(Collection objects,ZtreeNodeParser parser){
		return nodesByConllectings(objects,null,parser);
	}
	
	@SuppressWarnings("unchecked")
	public static List<TreeNode> nodesByConllectings(Collection allObjects,Collection checkedObjects,ZtreeNodeParser parser){
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (Object object : allObjects) {
			boolean checked = false;
			boolean isOpen = false;
			if(checkedObjects!=null){
				if(checkedObjects.contains(object)){
					checked = true;
					isOpen = true;
				}
			}
			TreeNode node = parser.Object2TreeNode(object);
			node.setChecked(checked);
			node.setOpen(isOpen);
			nodes.add(node);
		}
		return nodes;
	}
	
	
	
	

}
