package examples.InfoOperations;

import com.groupdocs.cloud.metadata.api.InfoApi;
import com.groupdocs.cloud.metadata.client.ApiException;
import com.groupdocs.cloud.metadata.model.FileInfo;
import com.groupdocs.cloud.metadata.model.MetadataProperty;
import com.groupdocs.cloud.metadata.model.Tag;
import com.groupdocs.cloud.metadata.model.TagsOptions;
import com.groupdocs.cloud.metadata.model.TagsResult;
import com.groupdocs.cloud.metadata.model.requests.TagsRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain metadata tags.
 */
public class GetMetadataTagsInformation {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/input.docx");
			fileInfo.setStorageName(Common.MyStorage);
			TagsOptions options = new TagsOptions();
			options.setFileInfo(fileInfo);
			TagsRequest request = new TagsRequest(options);
			TagsResult response = apiInstance.tags(request);

			System.out.println("Root package: " + response.getRootPackage().getPackageName());
			for (MetadataProperty entry : response.getRootPackage().getInnerPackages().get(0).getPackageProperties()) {
				System.out.println(entry.getName() + ": " + entry.getValue());
				if (entry.getTags() == null)
					continue;
				for (Tag tag : entry.getTags()) {
					System.out
							.println("Tag for property: name - " + tag.getName() + ", category - " + tag.getCategory());
				}
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}