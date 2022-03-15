package tp.basic.link;

//maillon abstrait (chain of responsability)
public abstract class AbstractLink {
	protected AbstractLink nextLink;
	
	public AbstractLink getNextLink() {
		return nextLink;
	}

	public void setNextLink(AbstractLink nextLink) {
		this.nextLink = nextLink;
	}
	
	
}
