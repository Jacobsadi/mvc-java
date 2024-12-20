<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<div class="table-responsive">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>DATE</th>
                <th>REFERENCE NO.</th>
                <th>DATA COLLECTED</th>
                <th>ACTIONS</th>
            </tr>
        </thead>
        <tbody>
            <!-- Example Row -->
            <tr>
                <td>22 June 2023</td>
                <td>MBIP088 / 0020</td>
                <td>
                    <div>WATER (L): 30</div>
                    <div>ENERGY (KWH): 150</div>
                    <div>RECYCLE (KG): 5</div>
                </td>
                <td>
                    <button class="btn btn-info btn-sm">🔍</button>
                    <button class="btn btn-success btn-sm">✔️</button>
                    <button class="btn btn-danger btn-sm">❌</button>
                </td>
            </tr>
            <!-- Additional rows as needed -->
        </tbody>
    </table>
</div>
