<!-- Add links to Bootstrap CSS and JS here if not already added -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>

<div id="box8">
    <ul class="nav nav-tabs" id="utilityTabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="water-tab" data-toggle="tab" href="#water" role="tab" aria-controls="water"
                aria-selected="true">Water</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="electricity-tab" data-toggle="tab" href="#electricity" role="tab"
                aria-controls="electricity" aria-selected="false">Electricity</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="recycling-tab" data-toggle="tab" href="#recycling" role="tab"
                aria-controls="recycling" aria-selected="false">Recycling</a>
        </li>
    </ul>

    <div class="tab-content" id="utilityTabContent">
        <div class="tab-pane fade show active" id="water" role="tabpanel" aria-labelledby="water-tab">
            <!-- Water form content here -->
        </div>
        <div class="tab-pane fade" id="electricity" role="tabpanel" aria-labelledby="electricity-tab">
            <!-- Electricity form content here -->
        </div>
        <div class="tab-pane fade" id="recycling" role="tabpanel" aria-labelledby="recycling-tab">
            <!-- Recycling form content here -->
        </div>
    </div>
</div>

Optional: Add some custom CSS to style the tabs if needed
<style>
    #box8 .nav-tabs .nav-link {
        color: #495057;
        background-color: #fff;
        border: 1px solid #dee2e6;
        border-bottom-color: transparent;
    }

    #box8 .nav-tabs .nav-link.active {
        color: #495057;
        background-color: #f8f9fa;
        border-color: #dee2e6 #dee2e6 #fff;
    }

    #box8 .tab-content {
        border: 1px solid #dee2e6;
        padding: 10px;
    }
</style>